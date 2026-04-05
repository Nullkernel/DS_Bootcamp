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

failures=0

echo "Compiling ${#java_files[@]} Java file(s) with isolated output folders..."

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
    failures=$((failures + 1))
  fi
done

if [[ $failures -gt 0 ]]; then
  echo
  echo "Java compile smoke test failed: $failures file(s) did not compile."
  exit 1
fi

echo
echo "Java compile smoke test passed."
