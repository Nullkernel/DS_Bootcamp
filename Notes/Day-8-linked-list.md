# Linked List:
It is a linear data structure where each element (called a node) contains data and a reference (or pointer) to the next node in the sequence. Unlike arrays, linked list do not store elements memory locations, allowing efficient insertions and deletions.

| (Head)   | (Next) |     |      |     |      |     |      |      |
| -------- | ------ | --- | ---- | --- | ---- | --- | ---- | ---- |
| A (Data) | --->   | B   | ---> | C   | ---> | D   | ---> | Null |

1. **Types of Linked List:**
	1. **Singly Linked List:** Each node points to the next node.
	2. **Doubly Linked List:** Each node points to both the next and the previous nodes.
	3. **Circular Linked List:** The last node points back to the first node. Forming a circle.

2. **Advantages:**
	1. **Dynamic size:** Can grow and shrink during runtime.
	2. **Ease of insertion and deletion:** No shifting of elements required.

3. **Disadvantages:**
	1. **Random access not allowed:** Must traverse sequentially.
	2. **Extra memory:** For storing sequences.

4. **Basic Operations:**
	1. **Insertion:** At the beginning, the end, or a given position.
	2. **Deletion:** From the beginning, the end, or a given position.
	3. **Traversal:** Visiting each node to display or process data.
	4. **Search:** To find an element in the list.
