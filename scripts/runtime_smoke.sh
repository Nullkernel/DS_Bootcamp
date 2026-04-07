#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$repo_root"

# Format per example:
# source_file|stdin_payload|expected_pattern_1;;expected_pattern_2...
examples=(
  'Searching-algorithms/Binarysearch.java|5\n1 3 5 7 9\n7|Entered Array: \[1, 3, 5, 7, 9\];;Element 7 Found at Index: 3'
  'Sorting-algorithms/Selectionsort.java|6\n8 3 1 7 0 4|Sorted array : \[0, 1, 3, 4, 7, 8\]'
  'Data-Structures/Trees/BinaryTree.java||Inorder traversal:;;Preorder traversal:;;Postorder traversal:;;44 12 17 27 56 3'
  'Data-Structures/Graphs/DFS.java||\[0, 1, 2, 3, 4\]'
  'Data-Structures/Hashing/HashTable.java||Updated key 8 with new data: 8800;;Found key 8 with data: 8800;;Cannot delete\. Key 1 not found\.;;Index 2 -> Key: 8, Data: 8800'
)

tmp_dir="$(mktemp -d)"
trap 'rm -rf "$tmp_dir"' EXIT

failures=0

echo "Runtime smoke test: compiling and executing ${#examples[@]} Java example(s)..."

for i in "${!examples[@]}"; do
  IFS='|' read -r source_file stdin_payload expected_patterns <<<"${examples[$i]}"

  if [[ ! -f "$source_file" ]]; then
    echo "[FAIL] $source_file"
    echo "  File not found."
    failures=$((failures + 1))
    continue
  fi

  class_name="$(basename "$source_file" .java)"
  work_dir="$tmp_dir/work/$i"
  out_dir="$tmp_dir/out/$i"
  output_file="$tmp_dir/output/$i.log"

  mkdir -p "$work_dir" "$out_dir" "$(dirname "$output_file")"

  compile_target="$work_dir/$source_file"
  mkdir -p "$(dirname "$compile_target")"
  cp "$source_file" "$compile_target"

  if ! javac -d "$out_dir" "$compile_target" >"$output_file" 2>&1; then
    echo "[FAIL] $source_file"
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  runtime_input="${stdin_payload//\\n/$'\n'}"

  if [[ -n "$runtime_input" ]]; then
    if ! java -cp "$out_dir" "$class_name" <<<"$runtime_input" >>"$output_file" 2>&1; then
      echo "[FAIL] $source_file"
      sed 's/^/  /' "$output_file"
      failures=$((failures + 1))
      continue
    fi
  else
    if ! java -cp "$out_dir" "$class_name" >>"$output_file" 2>&1; then
      echo "[FAIL] $source_file"
      sed 's/^/  /' "$output_file"
      failures=$((failures + 1))
      continue
    fi
  fi

  if grep -q "Exception in thread" "$output_file"; then
    echo "[FAIL] $source_file"
    echo "  Detected uncaught exception signature in runtime output."
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  IFS=';;' read -ra patterns <<<"$expected_patterns"
  mismatch=0
  for pattern in "${patterns[@]}"; do
    if ! grep -Eq "$pattern" "$output_file"; then
      if [[ $mismatch -eq 0 ]]; then
        echo "[FAIL] $source_file"
        echo "  Behavioral mismatch: expected output pattern(s) missing."
      fi
      mismatch=1
      echo "  Missing pattern: $pattern"
    fi
  done

  if [[ $mismatch -eq 1 ]]; then
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  echo "[PASS] $source_file"
done

if [[ $failures -gt 0 ]]; then
  echo
  echo "Java runtime smoke test failed: $failures example(s) failed runtime checks."
  exit 1
fi

echo
echo "Java runtime smoke test passed."
