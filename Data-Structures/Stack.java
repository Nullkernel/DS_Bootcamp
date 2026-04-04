import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }

    boolean isFull() {
        return top == maxSize - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot Push " + value);
            return;
        }
        arr[++top] = value;
        System.out.println(value + " Pushed to Stack.");
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot Pop.");
            return -1;
        }
        System.out.println(arr[top] + " Popped from Stack.");
        return arr[top--];
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Stack size: ");
        int size = sc.nextInt();

        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\n*** Stack Operations ***");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

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
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
