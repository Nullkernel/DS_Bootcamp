# `DSA`
This repository contains Java implementations of **Data Structures and Algorithms** developed during a Data Structures Bootcamp.  
It is designed to help understand core concepts through clean, readable, and beginner-friendly code.
The implementations prioritize simplicity and correctness over heavy optimization, making them suitable for learning, revision, and interview preparation.

---
## Repository Overview:
The repository is organized into folders based on topic for better navigation and clarity.
## Data-Structures:
**This directory contains implementations of fundamental data structures in Java, including:**

- Graphs:
    
    
    - Breadth-First Search (BFS).
    - Depth-First Search (DFS).
    - Dijkstra's algorithm.
- Hashing:
    - Hash Table.
- Linked List:
    - Circular Linked List. 
    - Doubly Linked List.
    - Singly Linked List.
- Queue:
    - Bounded Queue.
    - Circular Queue.
    - Priority Queue.
    - Linear Queue.
-Stack:
    - Linear Stack.
- Trees:
    - Trie:
        - Prefix Array.
        - Prefix Trie.
        - Suffix Array.
        - Suffix Trie.
        - Trie.
    - AVL Tree.
    - Binary Search Tree.
    - Binary Tree (manual traversal demo).
    - Binary Tree with insert/search/delete.

## Searching-algorithms:
**This directory includes Java implementations of common searching techniques:**
- Linear Search.
- Binary Search.
- Uniform Binary Search.
- Fibonacci Search.
- Interpolation Search.
  
The implementations demonstrate how different searching strategies behave under different conditions.
## Sorting-algorithms:
**This directory contains Java implementations of basic sorting algorithms such as:**
- Bubble Sort.
- Selection Sort.
- Insertion Sort.
- Quick Sort.
- Radix Sort.
- Merge Sort.
- Shell Sort.
- Heap sort.
  
These programs are written to clearly show algorithm flow and logic rather than micro-optimizations.
## Notes:
**This directory contains Markdown notes created during the bootcamp sessions.**  
**The notes explain:**
- Key concepts.
- Algorithm intuition.
- Important observations.
- Day wise concepts.
  
---
## Technology Stack:
- **Programming Language:** Java.
- **Development Environment:** Any Java-compatible IDE.
- **License:** MIT.
---
## How to Use This Repository?
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Pranav-173/DSA.git
   ```
   (or)
   
   ```bash
   git clone https://github.com/Nullkernel/DSA.git
   ```


## Development Checks
- Run a Java compile smoke test:
  ```bash
  ./scripts/compile_smoke.sh
  ```
- Compile smoke test details:
  - Scans `Searching-algorithms/`, `Sorting-algorithms/`, and `Data-Structures/`.
  - Compiles files in deterministic (sorted) order.
  - Uses isolated temporary output folders per file to avoid default-package collisions.
  - Prints `[PASS]` / `[FAIL]` per file and exits non-zero when any file fails.

- Run a Java runtime smoke test:
  ```bash
  ./scripts/runtime_smoke.sh
  ```
- Runtime smoke test details:
  - Compiles and executes selected runnable examples (currently `Data-Structures/Queue/BoundedQueue.java`).
  - Captures stdout/stderr from compile and runtime execution.
  - Fails if runtime output contains `Exception in thread`, catching uncaught exception regressions.
  - Exits non-zero when any runtime check fails.
