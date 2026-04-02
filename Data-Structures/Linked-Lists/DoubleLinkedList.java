import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class doublylinkedlist {
    private Node head;
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data + " Inserted from Beginning.");
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println(data + " Inserted at the End.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println(data + " Inserted at the End.");
    }
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("The List is Empty. Can't Delete element.");
            return;
        }
        System.out.println(head.data + " Deleted from Front.");
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("The List is Empty. Can't Delete element.");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data + " Deleted from End.");
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.data + " Deleted from End.");
        temp.prev.next = null;
    }
    public void search(int key) {
        if (head == null) {
            System.out.println("The List is Empty!");
            return;
        }
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " Found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println(key + " NOT Found in the List.");
    }
    public void displayforward() {
        if (head == null) {
            System.out.println("The List is Empty!");
            return;
        }
        Node temp = head;
        System.out.println("Forward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displaybackward() {
        if (head == null) {
            System.out.println("The List is Empty!");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println("Backward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
public class DoubleLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doublylinkedlist dll = new doublylinkedlist();
        int choice, data, position;
        do {
            System.out.println("\n---Linked List Operations Menu---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display Forward Direction");
            System.out.println("7. Display Backward Direction");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to Insert at Beginning: ");
                    data = sc.nextInt();
                    dll.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter element to Insert at End: ");
                    data = sc.nextInt();
                    dll.insertAtEnd(data);
                    break;
                case 3:
                    dll.deleteFromBeginning();
                    break;
                case 4:
                    dll.deleteFromEnd();
                    break;
                case 5:
                    System.out.print("Enter element to Search: ");
                    data = sc.nextInt();
                    dll.search(data);
                    break;
                case 6:
                    dll.displayforward();
                    break;
                case 7:
                    dll.displaybackward();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}
