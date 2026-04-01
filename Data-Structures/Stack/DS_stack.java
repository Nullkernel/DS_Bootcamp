import java.util.Scanner;

class Stack {
	static int MAX_SIZE;
	static int[] stack;
	static int top;
	public Stack(int x) {
		MAX_SIZE = x;
		stack = new int[MAX_SIZE];
		top = -1;
	}
	static boolean isFull() {
		return top == MAX_SIZE - 1;
	}
	static boolean isEmpty() {
		return top == -1;
	}
	static void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow! Cannot Push " + value);
			return;
		}
		stack[++top] = value;
		System.out.println(value + " Pushed to Stack.");
	}
	static int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow! Cannot Pop.");
			return -1;
		}
		System.out.println(stack[top] + " Popped from Stack.");
		return stack[top--];
	}
	static void display() {
		if (isEmpty()) {
			System.out.println("Stack is Empty!");
			return;
		}
		System.out.print("Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Stack size: ");
		int size = sc.nextInt();
		Stack stack = new Stack(size);
		while (true) {
			System.out.println("***** Stack Operations *****");
			System.out.println("1. Push\n2. Pop\n3. Display\n4. Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter value to Push: ");
					int value = sc.nextInt();
					stack.push(value);
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					stack.display();
					break;
				case 4:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}
