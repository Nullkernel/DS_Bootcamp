import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList {
    private Node head;
    // ---- Insert At Beginning ----
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    // ---- Insert At End ----
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // ---- Insert At position ----
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    // ---- Delete From Beginning ----
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        head = head.next;
    }
    // ---- Delete From End ----
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    // ---- Delete From position ----
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range!");
            return;
        }
        temp.next = temp.next.next;
    }
    // ---- Delete By Value ----
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        if (head.data == key) {
            head = head.next;
            System.out.println("Deleted element: " + key);
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
                System.out.println("Deleted element: " + key);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Element " + key + " not found. No deletion performed.");
    }
    public void search(int key) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + " Found at position: " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Element " + key + " NOT Found!");
    }
    public void display() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;
        do {
            System.out.println("\n--- Linked List Operations Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Delete by Value");
            System.out.println("8. Search");
            System.out.println("9. Display");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to Insert at Beginning: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter element to Insert at End: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter element to Insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter the position: ");
                    position = sc.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter the position: ");
                    position = sc.nextInt();
                    list.deleteFromPosition(position);
                    break;
                case 7:
                    System.out.print("Enter element value to Delete: ");
                    data = sc.nextInt();
                    list.deleteByValue(data);
                    break;
                case 8:
                    System.out.print("Enter element to Search: ");
                    data = sc.nextInt();
                    list.search(data);
                    break;
                case 9:
                    list.display();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 10);
        sc.close();
    }
}
