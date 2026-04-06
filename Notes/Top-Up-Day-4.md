# 1) Revised Heap Sort Using Max Heap and Min Heap:
## What is Heap Sort?
Heap sort is a comparison-based sorting technique based on a **heap** data structure.
A **heap** is a complete binary tree:
- **Max heap**: parent is greater than or equal to children.
- **Min heap**: parent is smaller than or equal to children.
## A) Heap Sort Using Max Heap:
### Idea:
Use a **max heap** to sort the array in **ascending order**.
### Why?
In a max heap, the largest element is always at the root. 
So we repeatedly remove the root and place it at the end of the array.
### Steps:
1. Build a max heap from the input array.
2. Swap the root with the last element.
3. Reduce heap size by 1.
4. Heapify the root again.
5. Repeat until the heap size becomes 1.
### Example:
Array: `4, 10, 3, 5, 1`.
Max heap formed:
`10, 5, 3, 4, 1`.
Then:
- Swap `10` with last element.
- `Heapify` remaining elements.
- Continue until sorted.
Final sorted array:
`1, 3, 4, 5, 10`.
### Result:
Using a **max heap** gives **ascending order**.
## B) Heap Sort Using Min Heap:
### Idea:
Use a **min heap** to sort the array in **descending order**.
### Why?
In a min heap, the smallest element is at the root.  
So we repeatedly remove the root and place it at the end.
### Steps:
1. Build a min heap from the input array.
2. Swap the root with the last element.
3. Reduce heap size by 1.
4. `Heapify` the root again.
5. Repeat.
### Result:
Using a **min heap** gives **descending order**.
## `Heapify`
`Heapify` means adjusting the tree to maintain heap property.
For a node at index `i`:
- Left child = `2i + 1`.
- Right child = `2i + 2`.
## Time Complexity:
- Build heap: `O(n)`.
- Each heapify: `O(log n)`.
- Total heap sort: `O(n log n)`.
## Space Complexity:
- `O(1)` extra space for array-based heap sort.
## Advantages of Heap Sort:
- Efficient sorting.
- No extra memory like merge sort.
- Time complexity is always `O(n log n)`.
## Disadvantages:
- Not stable.
- Slightly slower than quicksort in practice.
## Short Difference:
- **Max heap → ascending order**.
- **Min heap → descending order**.
# 2) Revised Priority Queue:
## What is a Priority Queue?
A priority queue is a special type of queue in which every element has a **priority**.
Elements are removed based on **priority**, not just arrival order.
## Types of Priority Queue:
### 1. Max Priority Queue:
- Highest priority element is removed first.
- Larger value = higher priority.
Example:
`(50, 40, 30)`.
Deletion order: `50 → 40 → 30`.
### 2. Min Priority Queue:
- Lowest priority element is removed first.
- Smaller value = higher priority.
Example:  
`(10, 20, 30)`.
Deletion order: `10 → 20 → 30`.
## Operations in Priority Queue:
- **Insert**.
- **Delete**.
- **Peek / Find Max or Min**.
- **`IsEmpty`**
## Implementation Methods:
### 1. Using Array:
- Simple to implement.
- Insertion may be easy.
- Deletion may take `O(n)` if you search for highest priority element.
### 2. Using Linked List:
- Insert and delete can be flexible.
- Still not as efficient as heap for large data.
### 3. Using Heap:
Best implementation for priority queue:
- Max heap → max priority queue.
- Min heap → min priority queue.
## Priority Queue Using Heap:
In heap implementation:
- Insert: add at end and `heapify`up.
- Delete: remove root and `heapify` down.
- Peek: root element.
### Max Priority Queue:
Root always contains the **maximum** element.
### Min Priority Queue:
Root always contains the **minimum** element.
## Applications:
- CPU scheduling.
- Printer queue.
- Dijkstra’s algorithm.
- Huffman coding.
- Network packet scheduling.
- Event simulation.
## Time Complexity Using Heap:
- Insert: `O(log n)`.
- Delete: `O(log n)`.
- Peek: `O(1)`.
# Priority Queue vs Normal Queue:

| **Normal Queue**              | **Priority Queue**                    |
| ----------------------------- | ------------------------------------- |
| Follows FIFO                  | Follows priority                      |
| First inserted, first deleted | Highest/lowest priority deleted first |
| Simple queue                  | Special queue                         |
