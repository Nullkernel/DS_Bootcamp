import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class circularlinkedlist {
    private Node tail;
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " inserted at the end");
    }
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        System.out.println(data + " inserted at the beginning");
    }
    public void deleteFromBeginning() {
        if (tail == null) {
            System.out.println("List is empty. Can't delete");
            return;
        }
        Node head = tail.next;
        if (head == tail) {
            System.out.println(head.data +" deleted from beginning.");
            tail = null;
        } else {
            System.out.println(head.data + " deleted from beginning");
            tail.next = head.next;
        }
    }
    public void deleteFromEnd(){
        if (tail == null) {
            System.out.println("List is empty. Can't delete");
            return;
        }
        System.out.println("Circular linked list.");
        Node temp = tail.next;
        do{
            System.out.println(temp.data +" ");
            temp = temp.next;
        }while(temp != tail.next);
        System.out.println();
        if(temp == tail){
            System.out.println(temp.data +" is deleted");
            tail = null;
        }
        else{
            while(temp.next != tail){
                temp = temp.next;
            }
            System.out.println(tail.data +" is deleted");
            temp.next = tail.next;
            tail = temp;
        }
    }
    public void display(){
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = tail.next; 
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next); 
        System.out.println("null");
    }
    public void search(int key){
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = tail.next;
        do{
            if(temp.data == key){
                System.out.println("Element " + key + " found ");
                return;
            }
        }
        while (temp != tail.next);
        System.out.println("Element " + key + " not found!");
    }
}
public class CircularLinkedLists {
    public static void main(String[] args) {
        circularlinkedlist cll = new circularlinkedlist();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;
        do {
            System.out.println("\n-----Circular Linked List Operations Menu -----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at beginning: ");
                    int frontdata = sc.nextInt();
                    cll.insertAtBeginning(frontdata);
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
                    int enddata = sc.nextInt();
                    cll.insertAtEnd(enddata);
                    break;
                case 3:
                    cll.deleteFromBeginning();
                    break;
                case 4:
                    cll.deleteFromEnd();
                    break;
                case 5:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    cll.search(key);
                    break;
                case 6:
                    cll.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!!");
            }
        } while (choice != 7);
        sc.close();
    }
}