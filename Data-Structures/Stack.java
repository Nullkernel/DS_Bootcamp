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

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println("Invalid input. Please enter an integer.");
            sc.next();
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Invalid input. Please enter an integer greater than 0.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = readPositiveInt(sc, "Enter the Stack size: ");

        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\n*** Stack Operations ***");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = readInt(sc, "Enter value to Push: ");
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
                    System.out.println("Invalid choice. Please enter a valid menu option.");
            }
        }
    }
}
