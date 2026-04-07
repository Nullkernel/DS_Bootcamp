import java.util.Scanner;

class MaxHeapPriorityQueue {
    int[] heap;
    int size;
    int capacity;
    // Constructor
    MaxHeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    // Insert element
    void insert(int value) {
        if (size == capacity) {
            System.out.println("Priority Queue is Full!");
            return;
        }
        heap[size] = value;
        int i = size;
        size++;

        // Heapify up
        while (i != 0 && heap[(i - 1) / 2] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;

            i = (i - 1) / 2;
        }
    }
    // Delete highest priority (max element)
    int delete() {
        if (size <= 0) {
            System.out.println("Priority Queue is Empty!");
            return -1;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }
    // Heapify (downward)
    void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }
    // Display queue
    void display() {
        if (size == 0) {
            System.out.println("Priority Queue is Empty!");
            return;
        }
        System.out.print("Priority Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(100);
        boolean running = true;
        while (running) {
            System.out.println("\n--- Priority Queue Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete (Highest Priority)");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    pq.insert(val);
                    break;
                case 2:
                    int deleted = pq.delete();
                    if (deleted != -1)
                        System.out.println("Deleted element: " + deleted);
                    break;
                case 3:
                    pq.display();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
