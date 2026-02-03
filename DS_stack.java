/*
//Stack :
push : Adds an element to the end of the Stack
pop : Remove an element from the top of the Stack
isempty : Check is the stack is empty
isFull : check if the stack is isFull
peek : displays the top element of the stack
Evaluation of postfix :
> read all the symbols one by one from left to right in the given postfix expression
> If the reading symbol is operand, then push it on to the stack
> If the reading symbol is operand then perform two pop operations and store the two poped operands in two diff 
variables. Then perform reading symbol operation using operand1 and operand2 and push the result back on to the stack.
> Finally perform a pop operation and display the poped value as final result
*//*
import java.util.Scanner;
import java.util.Stack;
public class DS_stack{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix expression : ");
        String postfix = sc.nextLine();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < postfix.length();i++){
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch)){
                s.push(ch - '0');
            }
            else{
                int operand2 = s.pop();
                int operand1 = s.pop();
                int result = 0;
                switch(ch){
                    case'+':result = operand1 + operand2;break;
                    case'-':result = operand1 - operand2;break;
                    case'*':result = operand1 * operand2;break;
                    case'/':result = operand1 / operand2;break;
                }
                s.push(result);
            }
        }
        System.out.println("Result = " + s.pop());
    }
}
*/
import java.util.Scanner;
public class DS_stack {
	static int MAX_SIZE = 100;
	static int[] stack = new int[MAX_SIZE];
	static int top = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n--- Stack Operations ---");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter value to push: ");
					int value = sc.nextInt();
					push(value);
					break;
				case 2:
					pop();
					break;
				case 3:
					display();
					break;
				case 4:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} 
        while (choice != 4);
		sc.close();
	}
	static boolean isFull() {
		return top == MAX_SIZE - 1;
	}
	static boolean isEmpty() {
		return top == -1;
	}
	static void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow! Cannot push " + value);
			return;
		}
		stack[++top] = value;
		System.out.println(value + " pushed to stack");
	}
	static int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow! Cannot pop");
			return -1;
		}
		System.out.println(stack[top] + " popped from stack");
		return stack[top--];
	}
	static void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		System.out.print("Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
