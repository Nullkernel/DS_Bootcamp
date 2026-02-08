# Bubble Sort:

**What it is?**
Bubble Sort repeatedly scans the array and swaps adjacent elements that are in the wrong order. Each full pass pushes the largest remaining element to its correct position (“bubbles up”) at the end.

**Algorithm (step-by-step):**  
Given array `A[0..n-1]`:
1. For `pass = 0` to `n-2`:
2. For `i = 0` to `n-2-pass`:
3. If `A[i] > A[i+1]` then swap `A[i]` and `A[i+1]`.
4. Optionally stop early if a pass makes **no swaps** (optimization).

**Time complexity:**
- **Best case:** `O(n)` — array already sorted and early-exit optimization used (one pass to confirm).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` — array in reverse order.

**Space complexity:**
- Auxiliary: `O(1)` — in-place.

**Other notes:**
- **Stable:** Yes (preserves relative order of equal elements). 
- **When to use:** Mostly educational or for tiny arrays; simple and stable but inefficient on large datasets.
---
# Insertion Sort:

**What it is?**  
Insertion Sort builds a sorted section of the array one element at a time. For each element, it inserts that element into the correct place among elements already sorted to its left.

**Algorithm (step-by-step):**  
Given array `A[0..n-1]`:
1. For `i = 1` to `n-1`:
2. `key = A[i]`
3. `j = i - 1`
4. While `j >= 0` and `A[j] > key`: set `A[j+1] = A[j]` and `j = j - 1`.
5. Set `A[j+1] = key`.

**Time complexity:**
- **Best case:** `O(n)` — array already sorted (only one comparison per element).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` — array reverse-sorted.

**Space complexity:**
- Auxiliary: `O(1)` — in-place.

**Other notes:**
- **Stable:** Yes.
- **Adaptive:** Yes — performs much better on nearly-sorted inputs (useful in hybrid sorts like `Timsort`).
- **When to use:** Small or nearly-sorted datasets; as the final pass in hybrid sorts.
---
# Selection Sort:

**What it is?**  
Selection Sort repeatedly selects the minimum element from the unsorted portion and swaps it into the next position of the sorted portion.

**Algorithm (step-by-step):**  
Given array `A[0..n-1]`:
1. For `i = 0` to `n-2`:
2. `minIndex = i`
3. For `j = i+1` to `n-1`: if `A[j] < A[minIndex]` then `minIndex = j`.
4. Swap `A[i]` and `A[minIndex]` (if `minIndex != i`).

**Time complexity:**
- **Best / Average / Worst:** `O(n^2)` — always scans remaining elements to find the minimum.

**Space complexity:**
- Auxiliary: `O(1)` — in-place.

**Other notes:**
- **Stable:** Not stable by default (swaps can change relative order of equal elements). Can be made stable with additional cost.
- **Adaptive:** No — does not benefit from existing order.
- **When to use:** Rare for large arrays; useful when the number of writes/swaps must be minimized (it does at most `n` swaps).
