# Stack Data Structure:
**Stack is a linear data structure that follows the Last in First out (LIFO) principle. The element inserted last is the one that is removed first.**

1. ### Characteristics of Stack:
	1. **LIFO Order:** The last inserted element is the first one to be removed.
	2. **Access Restriction:** Only one end, called the top is accessible for insertion  and deletion.
	3. **Dynamic/Static Implementation:** Using arrays (static) or linked list (dynamic).

2. ### Basic Operations:
	1. **`Push`**: Add a element to the top of the stack.
	2. **`Pop`:** Remove a element from top of the stack.
	3. **`Peek/Top`:** Return the top element without removing it.
	4. **`isEmpty`:** Check if the stack is empty.
	5. **`isFull`:** Check if the stack is full.

3. ### Applications:
	1. Reversing a string.
	2. Expression evaluation and conversion.
	3. Backtracking algorithms.
	4. Undo mechanism in editors.
	5. Syntax parsing in compilers.

**Postfix Expression Evaluation:**
- **Read each symbol in the provided postfix expression one at a time, from left to right. If the reading symbol is an operand, push it onto the stack. Otherwise, execute two pop operations and store the two popped operands in two different variables. Next, use operands `1` and `2` to perform a reading symbol action, then push the outcome back onto the stack. Lastly, do a pop operation and show the popped value as the final result.**<br/>
- `Ex:` `(2+3)*4` `=>`
`2 3 + 4 *`
