# **Recursion:**  
Recursion is a programming technique in which a function calls itself, either directly or indirectly, to solve a problem by breaking it down into smaller subproblems until a base condition is reached.

## **Uniform Binary Search (UBS):**  
Uniform Binary Search is a variation of the classical Binary Search algorithm. While Binary Search recalculates the midpoint in every iteration, Uniform Binary Search precomputes and stores the midpoints for a fixed-size array.

**Key Characteristics:**
1. Precomputed midpoints are used instead of calculating them dynamically.
2. Useful for systems with fixed-size memory or limited processing power.
3. Has the same time complexity as Binary Search.

**Time Complexity:**
- Best case: `O(1)`
- Average case: `O(log n)`
- Worst case: `O(log n)`

# **Sorting techniques:**  
Sorting is a fundamental topic in computer science that arranges the elements of a dataset in a specific order, usually ascending or descending. Sorted data enables efficient searching, merging, and analysis, and sorting is a prerequisite for many algorithms. Choosing a sorting technique depends on factors such as:

- **Size of the dataset**    
- **Memory constraints**
- **Nature of the data** (random, partially sorted, nearly sorted, etc.)

**Key terms in sorting**:
1. **Stable sort**:
    A sorting algorithm is _stable_ if it preserves the relative order of records with equal keys.  
    Example: If two students have the same marks, a stable sort will keep them in their original relative order.  
    Common stable algorithms: **Bubble Sort**, **Merge Sort**, **Insertion Sort**.
2. **In-place sort**:
    A sorting algorithm is _in-place_ if it requires only a constant amount of extra memory beyond the input array (i.e., O(1) auxiliary space).  
    Common in-place algorithms: **Quick Sort**, **Selection Sort**, **Bubble Sort**.
3. **Adaptive sort**:
    An _adaptive_ sorting algorithm takes advantage of existing order in the input. The more the input is already sorted, the fewer operations the algorithm needs to perform. Examples of adaptive behavior appear in **Insertion Sort** (fast on nearly-sorted arrays) and some optimized merge or hybrid sorts.
    **Examples:** Insertion Sort, `TimSort`, Optimized Bubble Sort.
4. **Comparison-based Sort**:
    A sorting algorithm is _comparison-based_ if it determines the order of elements by comparing pairs of elements. Typical examples include **Bubble Sort**, **Merge Sort**, **Quick Sort**, and **Heap Sort**.
5. **Non-comparison Sort**:
    A sorting algorithm is _non-comparison_ if it does not compare elements pairwise; instead it uses the actual values (or parts of the values) to determine position. Non-comparison sorts typically rely on counting, digit processing, or bucketing. Examples include **Counting Sort**, **Radix Sort**, and **Bucket Sort**.

**Summary table (terms & meanings):**
- **Stable sort:** - Maintains the relative order of equal elements (i.e., equal keys keep their original order).
- **In-place sort:** - Sorts using only a constant amount of extra space (O(1) auxiliary space).
- **Adaptive sort:** - Performs better when the input is already partially (or nearly) sorted.
- **Comparison-based sort:** - Determines the order of elements by comparing pairs of elements (e.g., quick-sort, merge-sort, heap-sort).
- **Non-comparison sort:** - Sorts by using element values (or parts of values) directly, without pairwise comparisons (e.g., counting sort, radix sort, bucket sort).
