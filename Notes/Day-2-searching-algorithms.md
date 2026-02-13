# Searching Techniques:
- It is a fundamental operation in computer science, that involves finding the presence or location of an element within a data structure, such as arrays or list. Efficient searching methods are essential for optimizing data retrieval and improving overall program performance.

- ### Important Searching algorithms are:
	- ## Linear Search:
   		- ### Definition: 
			It is the simplest searching algorithm that checks every element in a list sequentially until it finds the target element or reaches the end of the list. It doesn't require the data to be sorted and works well on small or unsorted data.
		
		- **Problem**: Search for a given element (`key`) on an array using the linear search technique.
		
		- **Input**: An array `arr[]` of size n and a target element key.
		
		- **Output**: Index of the `key` is found, otherwise returns `-1`.
		
		- ### Algorithm Steps:
			1. Start from the first element of the array.
			2. Compare the current element with the target element key.
			3. If the current element matches key, return the index.
			4. If not, move to the next element.
			5. Repeat steps `2` and `4` until the end of the array is reached.
			6. If no match is found after traversing the entire array, return `-1`.
			
		- ### Time Complexity:
		1. **Best Case:** `O(1)`  :
		    The element is found at the **first position**.
		2. **Average Case:** `O(n)`:  
		    The element is found somewhere in the **middle**.
		3. **Worst Case:** `O(n)`  :
		    The element is **last** or **not present** in the list.
		    
	- ## Binary Search:
		- ### Definition:
		    A divide-and-conquer search that repeatedly halves a **sorted** array by comparing the target with the middle element and discarding the half that cannot contain the target.
		    
		- **Problem:** Search for a given element (`key`) in a **sorted** array using binary search.
		
		- **Input:** A sorted array `arr[]` of size `n` and a target element `key`.
		
		- **Output:** Index where `key` is found; otherwise `-1`.    
		
		- ### Algorithm Steps (iterative):
		    1. Initialize `low = 0`, `high = n - 1`.
		    2. While `low <= high`:
		    3. Compute `mid = low + (high - low) / 2`.
		    4. If `arr[mid] == key`, return `mid`.
		    5. If `arr[mid] < key`, set `low = mid + 1`.
		    6. Else set `high = mid - 1`.
		    7. If loop exits without finding `key`, return `-1`.
		    
		- ### Key characteristics:
		    Requires sorted input. Very efficient (logarithmic). Works well for random-access arrays. Simple and stable.
		    
		- ### Time Complexity:
	    1. **Best Case:** `O(1)` - key is at `mid` on first check.
	    2. **Average Case:** `O(log n)` - halves the search space each comparison.
	    3. **Worst Case:** `O(log n)` - key absent or found after `log₂n` steps.
	    
	- ## Uniform Binary Search (UBS):
		- ### Definition:
		    A variant of binary search that uses a precomputed table of “offsets” (probe distances) so each step uses additions/indexing rather than computing `mid = low + (high-low)/2`. It is an iterative, table-driven form of binary search often used to avoid division or variable mid computation.
		    
		- **Problem:** Search for `key` in a sorted array `arr[]`, using uniform probes derived from the array size.
		
		- **Input:** A sorted array `arr[]` of size `n` and target `key`. (Precompute a small table for offsets up to `n`.)
		
		- **Output:** Index of `key` if found, otherwise `-1`.
		
		- ### Algorithm Steps (high-level):
		    1. Precompute a table of offsets (for sizes up to `n`) that indicate where to probe next - the table encodes the sequence of midpoints for successive interval sizes.
		    2. Set `index = initial_offset_for_n` and `low = 0`.
		    3. Compare `arr[index]` with `key`.
		    4. If equal, return `index`.
		    5. If `arr[index] < key`, move `low = index + 1` and select the next offset for the reduced size (using the table) to compute new `index`.
		    6. If `arr[index] > key`, shrink the considered size and pick the next offset accordingly.
		    7. Repeat until offsets are exhausted; return `-1` if not found.
		    
		- ### Key characteristics:
		    Avoids runtime division or variable midpoint computation by using precomputed probe offsets. Useful on hardware where division is expensive or for highly optimized, low-level implementations. Logic and complexity match binary search.
		    
		- ### Time Complexity:
		    1. **Best Case:** `O(1)` - found at the first probe.
		    2. **Average Case:** `O(log n)` - probes reduce interval exponentially.
		    3. **Worst Case:** `O(log n)`.
		    
	- ## Interpolation Search:
		- ### Definition:
		    A search technique that estimates the position of the target by interpolating within the range of key values (like guessing where a name would fall in a phone book), rather than always probing the midpoint. Works best when keys are **uniformly distributed** and numeric.
		    
		- **Problem:** Search for `key` in a **sorted** numeric array `arr[]` using value-based position estimation.
		
		- **Input:** A sorted numeric array `arr[]` (values comparable and preferably uniformly distributed) of size `n` and `key`.
		
		- **Output:** Index of `key` if found; otherwise `-1`.
		
		- ### Algorithm Steps:
		    1. Initialize `low = 0`, `high = n - 1`.
		    2. While `low <= high` and `key` is within `arr[low]`..`arr[high]`:
		    3. Estimate `pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low])`.
		    4. If `arr[pos] == key`, return `pos`.
		    5. If `arr[pos] < key`, set `low = pos + 1`.
		    6. Else set `high = pos - 1`.
		    7. If element not found, return `-1`.
		    
		- ### Key characteristics:
		    Best for uniformly distributed numeric data. Probes closer to the likely position - can be much faster than binary search on favorable distributions. Requires arithmetic (division, subtraction) and care when `arr[high] == arr[low]`.
		    
		- ### Time Complexity:
		    1. **Best Case:** `O(1)` - guessed position is correct immediately.
		    2. **Average Case:** `O(log log n)` - for uniformly distributed data.
		    3. **Worst Case:** `O(n)` - for highly skewed distributions or pathological input (degenerates to linear behavior).
		    
	- ## Fibonacci Search:
		- ### Definition:
		    A search algorithm that uses Fibonacci numbers to divide the array into sections for probing. It chooses probe positions based on Fibonacci offsets instead of halving the interval; like binary search but uses additions/subtractions of Fibonacci numbers to compute indices.
		    
		- **Problem:** Search for `key` in a **sorted** array `arr[]` using Fibonacci-based probes.
		
		- **Input:** A sorted array `arr[]` of size `n` and target `key`.
		
		- **Output:** Index of `key` if found; otherwise `-1`.
		
		- ### Algorithm Steps:
		    1. Generate the smallest Fibonacci number `fibM` such that `fibM >= n` (track `fibM`, `fibM_minus1`, `fibM_minus2`).
		    2. Set `offset = -1`.
		    3. While `fibM > 1`:
		    4. Compute `i = min(offset + fibM_minus2, n - 1)` - probe index.
		    5. If `arr[i] < key`: move right - set `fibM = fibM_minus1`, `fibM_minus1 = fibM_minus2`, `fibM_minus2 = fibM - fibM_minus1`, and `offset = i`.
		    6. If `arr[i] > key`: move left - set `fibM = fibM_minus2`, `fibM_minus1 = fibM_minus1 - fibM_minus2`, `fibM_minus2 = fibM - fibM_minus1`.
		    7. If `arr[i] == key`, return `i`.
		    8. After loop, if `fibM_minus1 == 1` and `offset + 1 < n` and `arr[offset + 1] == key`, return `offset + 1`.
		    9. If not found, return `-1`.
		    
		- ### Key characteristics:
		    Similar complexity to binary search (`O(log n)`) but uses Fibonacci numbers to pick probe indices. Historically useful where only addition/subtraction and array indexing are cheap operations (avoid division). Good for systems with slow mid computations or to guarantee certain probe patterns.
		    
		- ### Time Complexity:
		    1. **Best Case:** `O(1)` - found on first probe.
		    2. **Average Case:** `O(log n)`.
		    3. **Worst Case:** `O(log n)`.

## Asymptotic Analysis:
As input size grows very large, it becomes impractical to measure an algorithm's exact running time in seconds or steps. Instead we use asymptotic analysis to describe the general trend of an algorithm's performance as input size approaches infinity.

It focuses on dominant factors that influence growth, while ignoring constant multipliers and lower-order terms that have little effect on large inputs.

**This approach allows us to:**
1. Abstract away machine-specific details and implementation differences.
2. Compare algorithms based on their scalability and efficiency.
3. Understand the upper and lower bounds of algorithm performance.

### Types of Asymptotic Notations:

#### Asymptotic notations provide a formal way to describe the growth rates of functions representing an algorithm’s time or space complexity. The main asymptotic notations are:

- **Big-O Notation `(O)`** - Provides an upper bound on the growth rate. It describes the worst-case scenario: the algorithm’s running time will not exceed this bound for sufficiently large inputs.

- **Big-Ω (Omega) Notation `(Ω)`** - Provides a lower bound on the growth rate. It describes the best-case scenario: the running time will be at least this much for sufficiently large inputs.

- **Big-Θ (Theta) Notation `(Θ)`** - Provides a tight (both upper and lower) bound: the algorithm grows at this exact asymptotic rate (within constant factors).

- **little-o Notation `(o)`** - Describes a strict upper bound: `f(n) = o(g(n))` means `f` grows strictly slower than `g` (for any constant `c > 0`, eventually `f(n) < c·g(n)`).

### Space Complexity:
Space complexity refers to the amount of memory (space) an algorithm needs to run to completion. It includes all memory and its usage during execution, including variables, data structures, function calls, and temporary storage.

### Types of Memory Used:

1. **Instruction space** - Memory required to store the compiled version of the program (code).
2. **Activation stack / Call stack** - Space required for function calls: parameters, return addresses, and local variables.
3. **Heap** - Dynamically allocated memory during runtime (objects, dynamic arrays, etc.).
4. **Input/Output data space** - Space required to store input and output data buffers.

### Common Space Complexities:
1. **`O(1)`** - Constant space: the algorithm uses a fixed amount of extra memory regardless of input size.
2. **`O(n)`** - Linear space: auxiliary memory used grows proportionally with input size.
3. **`O(n²)`** - Quadratic space: used by algorithms that store `2D` structures or pairwise data (e.g., some matrix or naive graph algorithms).
