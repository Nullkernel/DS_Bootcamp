# Queue Interface:
## Add Method:
- This method is part of the `Queue` interface and is generally used to insert an element into the queue.  
- If the queue is full and cannot accept the new element due to capacity constraints, it throws an `IllegalStateException`.
- **Syntax:** `add(E e)`
- **Returns:** `true` if the element is added successfully.
## Deletion Methods:
### 1. `remove()`
- This method removes and returns the front element of the queue.  
- If the queue is empty, it throws a `NoSuchElementException`.
- **Syntax:** `remove()`
- **Use:** When you want to delete the head element and get its value.
### 2. `poll()`
- This method also removes and returns the front element of the queue.  
- But if the queue is empty, it does **not** throw an exception. Instead, it returns `null`.
- **Syntax:** `poll()`
- **Use:** When you want safe deletion without an error if the queue is empty.
## Difference Between `remove()` and `poll()`
- `remove()` → throws exception if queue is empty.
- `poll()` → returns `null` if queue is empty.
## Example:
If the queue contains: `10, 20, 30`
- `remove()` returns `10` and deletes it.
- `poll()` returns `10` and deletes it.
If the queue is empty:
- `remove()` → error
- `poll()` → `null`
