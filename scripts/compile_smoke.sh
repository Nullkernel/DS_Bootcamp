#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$repo_root"

search_roots=(
  "Searching-algorithms"
  "Sorting-algorithms"
  "Data-Structures"
)

mapfile -t java_files < <(
  find "${search_roots[@]}" -type f -name '*.java' 2>/dev/null | LC_ALL=C sort
)

if [[ ${#java_files[@]} -eq 0 ]]; then
  echo "No Java files found in target directories: ${search_roots[*]}"
  exit 0
fi

tmp_dir="$(mktemp -d)"
trap 'rm -rf "$tmp_dir"' EXIT

combined_out_dir="$tmp_dir/combined_out"
combined_err_file="$tmp_dir/combined.err"
mkdir -p "$combined_out_dir"

echo "Phase 1/2: Compiling ${#java_files[@]} Java file(s) together into one output folder..."

conflict_failures=0
if javac -d "$combined_out_dir" "${java_files[@]}" > /dev/null 2>"$combined_err_file"; then
  echo "[PASS] Combined compilation"
else
  echo "[FAIL] Combined compilation"

  conflict_log="$tmp_dir/combined.conflicts"
  other_log="$tmp_dir/combined.other"
  : >"$conflict_log"
  : >"$other_log"

  while IFS= read -r line; do
    if [[ "$line" =~ duplicate[[:space:]]+class ]] || [[ "$line" =~ package[[:space:]].*[[:space:]]clashes[[:space:]]with ]] || [[ "$line" =~ class[[:space:]].*[[:space:]]is[[:space:]]already[[:space:]]defined ]]; then
      printf '%s\n' "$line" >>"$conflict_log"
    else
      printf '%s\n' "$line" >>"$other_log"
    fi
  done <"$combined_err_file"

  if [[ -s "$conflict_log" ]]; then
    conflict_failures=1
    echo "  Package/class-name conflict diagnostics:"
    sed 's/^/    /' "$conflict_log"
  fi

  if [[ -s "$other_log" ]]; then
    echo "  Non-conflict diagnostics from combined compilation:"
    sed 's/^/    /' "$other_log"
  fi
fi

isolated_failures=0

echo
echo "Phase 2/2: Compiling with isolated output folders for localized diagnostics..."

for i in "${!java_files[@]}"; do
  file="${java_files[$i]}"

  work_dir="$tmp_dir/work/$i"
  out_dir="$tmp_dir/out/$i"
  err_file="$tmp_dir/err/$i.log"
  mkdir -p "$work_dir" "$out_dir" "$(dirname "$err_file")"

  compile_target="$work_dir/$file"
  mkdir -p "$(dirname "$compile_target")"
  cp "$file" "$compile_target"

  if javac -d "$out_dir" "$compile_target" > /dev/null 2>"$err_file"; then
    echo "[PASS] $file"
  else
    echo "[FAIL] $file"
    sed 's/^/  /' "$err_file"
    isolated_failures=$((isolated_failures + 1))
  fi
done

if [[ $conflict_failures -gt 0 || $isolated_failures -gt 0 ]]; then
  echo
  if [[ $conflict_failures -gt 0 ]]; then
    echo "Java compile smoke test detected package/class-name conflicts in combined compilation."
  fi
  if [[ $isolated_failures -gt 0 ]]; then
    echo "Java compile smoke test failed: $isolated_failures file(s) did not compile in isolated mode."
  fi
  exit 1
fi

echo
echo "Java compile smoke test passed."
