import java.util.Scanner;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than 0");
        }
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is Full. Can't Enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println(item + " Enqueued to Queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. Can't Dequeue.");
            return;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;

        if (count == 0) {
            front = 0;
            rear = -1;
        }

        System.out.println(item + " Dequeued from Queue.");
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println("Front element is: " + arr[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}

public class CircularQueue {
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
        int capacity = readPositiveInt(sc, "Enter Queue size: ");

        Queue queue = new Queue(capacity);
        int choice;

        do {
            System.out.println("\n--- Circular Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Full?");
            System.out.println("6. Is Empty?");
            System.out.println("7. Exit");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int element = readInt(sc, "Enter element to Enqueue: ");
                    queue.enqueue(element);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println(queue.isFull() ? "The Queue is Full." : "The Queue is NOT Full.");
                    break;

                case 6:
                    System.out.println(queue.isEmpty() ? "The Queue is Empty." : "The Queue is NOT Empty.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid menu option.");
            }
        } while (choice != 7);

        sc.close();
    }
}
