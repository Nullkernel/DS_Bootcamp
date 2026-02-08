# Quick sort:

**What it is:**  
Quick sort is a divide-and-conquer sorting algorithm that partitions an array around a pivot so that elements less than the pivot go left and greater go right, then recursively sorts the partitions.

**Algorithm (step-by-step):**

1. Choose a pivot element (common choices: first, last, random, median-of-three).
2. Partition the array into two parts: elements ≤ pivot on one side and elements ≥ pivot on the other (partition schemes: `Lomuto`, Hoare).
3. Recursively apply quick sort to the left and right partitions.
4. (Optional) Use tail-recursion elimination or sort smaller partition first to limit recursion depth. Many implementations fall back to insertion sort for tiny subarrays.

**Time complexity:**
- Best case: O(n log n) - partitions split evenly.
- Average case: O(n log n).
- Worst case: O(n^2) - bad pivots repeatedly (e.g., always choose min/max on already sorted data).

**Space complexity:**
- Auxiliary / stack: O(log n) on average (recursion).
- Worst-case stack depth: O(n) if partitions are maximally unbalanced.

**Other notes:**

- Not stable by default (swaps can change relative order).
- Typically in-place (needs only O(1) extra array space).
- Excellent practical performance and cache behavior; pivot selection and randomization are important to avoid worst-case behavior.
- Common production improvement: _introsort_ (quick sort with a fallback to heap sort if recursion gets too deep).

# Merge sort:

**What it is:**  
Merge sort is a divide-and-conquer algorithm that splits the array in halves, recursively sorts each half, and then merges the two sorted halves.

**Algorithm (step-by-step):**
1. If the array has 0 or 1 element, it is sorted (base case).
2. Split the array into two halves.
3. Recursively sort each half.
4. Merge the two sorted halves into a single sorted array using a linear-time merge pass.

**Time complexity:**
- Best case: O(n log n).
- Average case: O(n log n).
- Worst case: O(n log n).

**Space complexity:**
- Auxiliary: O(n) for array-based merge (needs temporary buffer to merge).
- For linked lists, merge can be done with O(1) extra space by re-linking nodes (so space depends on data structure).

**Other notes:**
- Stable by nature (if merging preserves order of equal elements).
- Predictable runtime and great for external sorting and parallelization.
- Not in-place for arrays (standard array-based merge requires O(n) extra).
- Good choice when worst-case guarantees and stability are required.

# Radix sort:

**What it is:**  
Radix sort is a non-comparison sorting method that sorts keys by processing individual digits/parts (e.g., least-significant-digit or most-significant-digit passes), typically using a stable subroutine (like counting sort) per digit.

**Algorithm (step-by-step, LSD variant):**

1. Choose a radix/base `k` (e.g., 10 for decimal digits, 256 for bytes) and the number of digit positions `d`.
2. For `pos = 0` (least significant) to `d-1`:
    - Stable-sort the array by the digit at `pos` (counting-sort is usual).
3. After processing all digit positions, the array is fully sorted.

**Time complexity:**
- O(d * (n + k)) where `d` = number of digits and `k` = radix (digit range).
- If `d` and `k` are small constants (fixed-size integers or bounded-length strings), runtime is effectively O(n).

**Space complexity:**
- O(n + k) auxiliary for counting/buckets (depends on stable subroutine).

**Other notes:**
- Not comparison-based; can achieve linear time for fixed-length keys.
- Stable if the per-digit sorting is stable (required for correctness in LSD radix).
- Works best for integers, fixed-length strings, or when key-length/ radix are bounded.
- Careful with memory if `k` is large; choose base to trade off passes vs bucket size.

# Shell sort:

**What it is:**  
Shell sort generalizes insertion sort by first sorting elements far apart (using a gap), then progressively reducing the gap until performing a final insertion-sort pass with gap = 1. This reduces large-scale disorder quickly.

**Algorithm (step-by-step):**
1. Choose a gap sequence (common sequences: n/2, n/4, ...; `Ciura` sequence is a practical choice).
2. For each gap value `g` (from large to 1):
    - Perform a gapped insertion sort: treat elements `i, i+g, i+2g, ...` as a subarray and insertion-sort them.
3. Continue until `g = 1`, after which a final regular insertion sort finishes the job.

**Time complexity:**
- Depends strongly on the chosen gap sequence; there is no single tight bound that covers all sequences.
- Empirically, good gap sequences give substantially better than O(n^2) on average (practical average often between roughly O(n^{1.25}) and O(n^{1.5}), depending on sequence and input).
- Worst-case complexity can be as bad as O(n^2) for simple gap sequences; some special sequences have proven sub-quadratic worst-case bounds.

**Space complexity:**
- Auxiliary: O(1) - in-place.

**Other notes:**
- Not stable.
- In-place and fairly simple to implement.
- Adaptive to a degree because later passes benefit from prior gapped sorts.
- Often very fast for medium-sized arrays and used as a low-overhead improvement over plain insertion sort.
- Performance and guarantees depend on gap choice; using well-studied sequences (e.g., Ciura) gives good practical performance.
