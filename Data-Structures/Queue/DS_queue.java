import java.util.Scanner;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    public Queue(int size) {
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
        arr[++rear] = item;
        count++;
        System.out.println(item + " Enqueued to Queue.");
    }
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. Can't Dequeue.");
            return;
        }
        int item = arr[front++];
        count--;
        System.out.println(item + " Dequeued from Queue.");
    }
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println("Front element is: "+ arr[front]);
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println("Queue Elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == capacity;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Queue size: ");
        int capacity = sc.nextInt();
        Queue queue = new Queue(capacity);
        while (true) {
            System.out.println("***** Queue Operations *****");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Is Full?\n6. Is Empty?\n7. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to Enqueue: ");
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
