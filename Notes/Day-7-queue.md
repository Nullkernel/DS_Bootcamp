# Queue:
A Queue is a linear data structure that follows the first in first out principle (FIFO).

This means that the element inserted first will be removed first. It is analogous to a line of people waiting for a service. Where the person at the front is served first.

1. **A Queue performs the following operations:**
	1. **enqueue:** Inserts an element at the rear of the queue.
	2. **dequeue:** Removes and returns the first element.
	3. **peek/front:** Returns the front element.
	4. `isEmpty`: Checks whether the queue is empty.
	5. `isFull`: Checks whether the queue is full.
	6. **size:** Returns the number of elements in the queue.

2. **Applications of Queue:**
	1. **CPU Scheduling:** Ready queue in OS Schedules process in FIFO order.
	2. To print Queue. 
	3. BFS, etc.

3. **Types of Queues:**
	1. **Simple Queue:** Basic FIFO queue (linear queue).
	2. **Circular Queue:**
		Connects the last position to the first position to utilize the free space efficiently. It is a linear data structure that overcomes the limitations of a simple queue's wasted space by connecting the end of the queue back to the front. Forming a circle. This allows efficient utilization of the storage by revising the empty space created by dequeuing the elements.
		1. **Characteristics:**
			1. FIFO principle.
			2. Rear and front positions wrap around when they reach the end of the array.
			3. Helps to avoid the "queue full" problem seen in simple queue where space wasted.
		
	3. **Priority Queue:** Each element is assigned a priority and elements with higher priority are dequeued first.
	4. **Double-Ended Queue:** 
		Elements can be added or removed from both ends. It is a generalized version of a queue where characters can be inserted or removed from both the front and rear ends. It combines the principle of of both stack and queue.
		 1. **Operations:**
			 1. `insertFront(element)`: Add an element to the front end.
			 2. `insertRear(element)`: Add an element to the rear end.
			 3. `deleteFront()`: Remove an element from the front end.
			 4. `deleteEmpty()`: Remove an element from the rear end.
			 5. `peekFront()`: Get the front element.
			 6. `peakRear()`: Get the rear element.

**Example for simple/linear queue:**

| (Front) |     |     |     |     | (Rear) |
| ------- | --- | --- | --- | --- | ------ |
| 5       | 10  | 15  | 20  | 25  | 30     |
