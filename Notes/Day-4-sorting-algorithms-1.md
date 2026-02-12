# **Sorting techniques:**  
Sorting is a fundamental topic in computer science that arranges the elements of a dataset in a specific order, usually ascending or descending. Sorted data enables efficient searching, merging, and analysis, and sorting is a prerequisite for many algorithms. Choosing a sorting technique depends on factors such as:

- **Size of the dataset**    
- **Memory constraints**
- **Nature of the data** (random, partially sorted, nearly sorted, etc.)

## Key terms in sorting:
1. ### Stable sort:
    A sorting algorithm is _stable_ if it preserves the relative order of records with equal keys.  
    Example: If two students have the same marks, a stable sort will keep them in their original relative order.  
    Common stable algorithms: **Bubble Sort**, **Merge Sort**, **Insertion Sort**.
2. ### In-place sort:
    A sorting algorithm is _in-place_ if it requires only a constant amount of extra memory beyond the input array (i.e., O(1) auxiliary space).  
    Common in-place algorithms: **Quick Sort**, **Selection Sort**, **Bubble Sort**.
3. ### Adaptive sort:
    An _adaptive_ sorting algorithm takes advantage of existing order in the input. The more the input is already sorted, the fewer operations the algorithm needs to perform. Examples of adaptive behavior appear in **Insertion Sort** (fast on nearly-sorted arrays) and some optimized merge or hybrid sorts.
    **Examples:** Insertion Sort, `TimSort`, Optimized Bubble Sort.
4. ### Comparison-based Sort:
    A sorting algorithm is _comparison-based_ if it determines the order of elements by comparing pairs of elements. Typical examples include **Bubble Sort**, **Merge Sort**, **Quick Sort**, and **Heap Sort**.
5. ### Non-comparison Sort:
    A sorting algorithm is _non-comparison_ if it does not compare elements pairwise; instead it uses the actual values (or parts of the values) to determine position. Non-comparison sorts typically rely on counting, digit processing, or bucketing. Examples include **Counting Sort**, **Radix Sort**, and **Bucket Sort**.

## Summary table (terms & meanings):
- **Stable sort:** - Maintains the relative order of equal elements (i.e., equal keys keep their original order).
- **In-place sort:** - Sorts using only a constant amount of extra space (O(1) auxiliary space).
- **Adaptive sort:** - Performs better when the input is already partially (or nearly) sorted.
- **Comparison-based sort:** - Determines the order of elements by comparing pairs of elements (e.g., quick-sort, merge-sort, heap-sort).
- **Non-comparison sort:** - Sorts by using element values (or parts of values) directly, without pairwise comparisons (e.g., counting sort, radix sort, bucket sort).

# Bubble Sort:

## What it is?
Bubble Sort repeatedly scans the array and swaps adjacent elements that are in the wrong order. Each full pass pushes the largest remaining element to its correct position (“bubbles up”) at the end.

## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `pass = 0` to `n-2`:
2. For `i = 0` to `n-2-pass`:
3. If `A[i] > A[i+1]` then swap `A[i]` and `A[i+1]`.
4. Optionally stop early if a pass makes **no swaps** (optimization).

## Time complexity:
- **Best case:** `O(n)` - array already sorted and early-exit optimization used (one pass to confirm).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` - array in reverse order.

## Space complexity:
- Auxiliary: `O(1)` - in-place.

### Other notes:
- **Stable:** Yes (preserves relative order of equal elements). 
- **When to use:** Mostly educational or for tiny arrays; simple and stable but inefficient on large datasets.
---
# Insertion Sort:

## What it is?
Insertion Sort builds a sorted section of the array one element at a time. For each element, it inserts that element into the correct place among elements already sorted to its left.

## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `i = 1` to `n-1`:
2. `key = A[i]`
3. `j = i - 1`
4. While `j >= 0` and `A[j] > key`: set `A[j+1] = A[j]` and `j = j - 1`.
5. Set `A[j+1] = key`.

## Time complexity:
- **Best case:** `O(n)` - array already sorted (only one comparison per element).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` - array reverse-sorted.

## Space complexity:
- Auxiliary: `O(1)` - in-place.

### Other notes:
- **Stable:** Yes.
- **Adaptive:** Yes - performs much better on nearly-sorted inputs (useful in hybrid sorts like `Timsort`).
- **When to use:** Small or nearly-sorted datasets; as the final pass in hybrid sorts.
---
# Selection Sort:

## What it is?
Selection Sort repeatedly selects the minimum element from the unsorted portion and swaps it into the next position of the sorted portion.

## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `i = 0` to `n-2`:
2. `minIndex = i`
3. For `j = i+1` to `n-1`: if `A[j] < A[minIndex]` then `minIndex = j`.
4. Swap `A[i]` and `A[minIndex]` (if `minIndex != i`).

## Time complexity:
- **Best / Average / Worst:** `O(n^2)` - always scans remaining elements to find the minimum.

## Space complexity:
- Auxiliary: `O(1)` - in-place.

### Other notes:
- **Stable:** Not stable by default (swaps can change relative order of equal elements). Can be made stable with additional cost.
- **Adaptive:** No - does not benefit from existing order.
- **When to use:** Rare for large arrays; useful when the number of writes/swaps must be minimized (it does at most `n` swaps).
