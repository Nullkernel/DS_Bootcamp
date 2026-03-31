#### Stack Revision:
A Stack is a Linear Data Structure that follows the principle of the Last In First Out (LIFO). This means the last element inserted inside the stack is removed first.
#### Basic Operations:
- **`Push`**: Adds an element to the top of the Stack.
- **`Pop`**: Removes an element from the top of the Stack.
- **`isEmpty`**: Checks if the Stack is empty.
- **`isFull`**: Checks if the the Stack is full.
- **`Peek`**: Gets the value of the element of the stack without removing it.

#### Time Complexity: `O(1)`

# Arithmetic Expression Evaluation:
## Precedence Rule (or) Operator Precedence:
It determines which operation is performed first in an expression with more than one operator having different precedence.  
For example, in `A + B * C`, multiplication is performed before addition because `*` has higher precedence than `+`.
## Associativity Rule (or) Operator Associativity:
It determines the order of evaluation when two or more operators have the same precedence.
- **Left to right associativity**: the operation on the left is performed first.  
    Example: `A - B - C` is evaluated as `(A - B) - C`
- **Right to left associativity**: the operation on the right is performed first.  
    Example: `A ^ B ^ C` is evaluated as `A ^ (B ^ C)`
For stack-based expression evaluation, precedence and associativity are used to decide whether an operator should be pushed onto the stack or whether operators already in the stack should be popped first.

## Infix to prefix (without stack) for: `a+b*c-d/e^f`
### Step by step, without using a stack
1. `^` has the highest precedence  
    So `e^f` becomes `^ e f`
2. Then `/` and `*`  
    So:
    - `b*c` becomes `* b c`
    - `d/e^f` becomes `/ d ^ e f`
3. Then `+` and `-`  
    The expression is really:  
    `(a + b*c) - (d / e^f)`
4. Convert the whole thing to prefix:
    - left part: `+ a * b c`
    - right part: `/ d ^ e f`
    - main operator: `-`
So the final prefix is:
`- + a * b c / d ^ e f`
# Using Stack:
## Infix to prefix (using stack) for: `f^e/d-c*b+a`:
- **Given Infix:** `f ^ e / d - c * b + a`
- **Reverse the expression:** `a + b * c - d / e ^ f`
- ### Precedence:
	- `^ > * / > + -`  
	- `^` is **right associative**, others **left associative**.

| Symbol | Stack | Output   |
| ------ | ----- | -------- |
| a      |       | a        |
| +      | +     | a        |
| b      | +     | ab       |
| *      | + *   | ab       |
| c      | + *   | abc      |
| -      | -     | abc*+    |
| d      | -     | abc*+d   |
| /      | - /   | abc*+d   |
| e      | - /   | abc*+de  |
| ^      | - / ^ | abc*+de  |
| f      | - / ^ | abc*+def |

**Pop remaining stack:**
- Pop `^`, `/`, `-`
- Postfix: `abc*+def^/-`
- **Reverse postfix → PREFIX:**
- `- / ^ f e d + * c b a`
