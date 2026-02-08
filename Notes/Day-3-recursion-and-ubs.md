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
