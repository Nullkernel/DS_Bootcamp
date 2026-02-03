/*
//Queue : A queue is a linear data structure that follows first-in first-out principle. 
> Enqueue: Adds a new element to the queue.
> Dequeue: Removes and returns the first (front) element from the queue.
> Peek: Returns the first element in the queue.
> isEmpty: Checks if the queue is empty.
> Size: Finds the number of elements in the queue.
*/
import java.util.Scanner;
public class DS_queue{
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    public DS_queue(int size){
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }
    public void enqueue(int item){
        if(isFull()){
            System.out.println("Queue is full. Can't enqueue "+ item);
            return;
        }
        arr[++rear] = item;
        count++;
        System.out.println(item +" enqueued to queue.");
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.Can't dequeue.");
            return;
        }
        int item = arr[front++];
        count--;
        System.out.println(item +" dequeued from queue.");
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element is : "+ arr[front]);
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue Elements : ");
        for(int i = 0; i < count; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == capacity;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter queue size : ");
        int capacity = sc.nextInt();
        DS_queue queue = new DS_queue(capacity);
        int choice;
         do{
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. peek");
			System.out.println("4. Display");
            System.out.println("5. Is full");
            System.out.println("6. Is empty");
            System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter element to enqueue : ");
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
                    System.out.println(queue.isFull() ? "The queue is full." : "The queue is not full.");
                    break;
                case 6:
                    System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
                    break;            
                case 7:
                    System.out.println("Exititng .....");
                    break;
                default:
                    System.out.println("Invalid choice!");
			}
		} 
        while (choice != 7);
		sc.close();
    }
}
