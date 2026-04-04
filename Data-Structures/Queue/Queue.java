import java.util.Scanner;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public Queue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            if (front > 0) {
                int j = 0;
                for (int i = front; i <= rear; i++) {
                    arr[j++] = arr[i];
                }
                rear = j - 1;
                front = 0;
            }
        }

        if (isFull()) {
            System.out.println("Queue is Full. Can't Enqueue " + item);
            return;
        }

        arr[++rear] = item;
        System.out.println(item + " Enqueued to Queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. Can't Dequeue.");
            return;
        }

        int item = arr[front++];
        System.out.println(item + " Dequeued from Queue.");

        if (front > rear) {
            front = 0;
            rear = -1;
        }
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
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Queue size: ");
        int capacity = sc.nextInt();

        Queue queue = new Queue(capacity);

        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Full?");
            System.out.println("6. Is Empty?");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to Enqueue: ");
                    int element = sc.nextInt();
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
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
