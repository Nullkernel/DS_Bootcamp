#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$repo_root"

tmp_dir="$(mktemp -d)"
cleanup() {
  rm -rf "$tmp_dir"
}
trap cleanup EXIT

failures=0

while IFS= read -r file; do
  class_name="$(sed -n 's/^public class \([A-Za-z_][A-Za-z0-9_]*\).*/\1/p' "$file" | head -n1)"
  if [[ -n "$class_name" ]]; then
    compile_target="$tmp_dir/${class_name}.java"
    cp "$file" "$compile_target"
  else
    compile_target="$file"
  fi

  if ! javac -d "$tmp_dir" "$compile_target" >/dev/null 2>"$tmp_dir/javac.err"; then
    echo "[FAIL] $file"
    cat "$tmp_dir/javac.err"
    failures=$((failures + 1))
  else
    echo "[PASS] $file"
  fi

done < <(rg --files -g '*.java' | sort)

if [[ $failures -gt 0 ]]; then
  echo "\nJava compile smoke test failed: $failures file(s) did not compile."
  exit 1
fi

echo "\nJava compile smoke test passed."
