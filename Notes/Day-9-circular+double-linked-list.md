# Circular Linked List:
**A circular linked list is a variation of a linked list where the last node is connected or points back to the first node instead of null. Forming a circle. It can either be singly linked or doubly linked.**

`Eg:`

| (Data) | (Next) |     |       |     |       |     |
| ------ | ------ | --- | ----- | --- | ----- | --- |
| 11     | -----> | 22  | ----> | 33  | ----> | 44  |
 
 ^=================================='

1. Basic Operations:
	1. Insertion: At the beginning, end or at any given position.
	2. Deletion: From the beginning, end or at any given position.
	3. Traversal: Starting from head and looping back.
	4. Search: Find an element by traversing the nodes.

# Doubly Linked List:
It is a type of linked list in which each node contains three fields: data, a reference to the the next node, and the reference to the previous node. This allows traversal in both forward and backward directions.

1. Basic Operations:
	1. Insertion: At the beginning, end or at any given position.
	2. Deletion: From the beginning, end or at any given position.
	3. Traversal: Forward and backward traversal.
	4. Search: Find an element by traversing the nodes.



| (Start) | (Head)   |     | (`Next`) | --->     |     | (`Next`) | --->     |     | (`Next`) | --->     |     | (`Next`) | --->   |
| ------- | -------- | --- | ------ | -------- | --- | ------ | -------- | --- | ------ | -------- | --- | ------ | ------ |
| (Null)  |          | A   |        |          | B   |        |          | C   |        |          | D   |        | (Null) |
| <---    | (`Prev`) |     | <---   | (`Prev`) |     | <---   | (`Prev`) |     | <---   | (`Prev`) |     | ---    | ---    |
