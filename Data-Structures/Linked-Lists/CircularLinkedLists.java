import java.util.Scanner;

class CircularLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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

        System.out.println(data + " Inserted at the End.");
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

        System.out.println(data + " Inserted at the Beginning.");
    }

    public void deleteFromBeginning() {
        if (tail == null) {
            System.out.println("List is Empty. Can't Delete.");
            return;
        }

        Node head = tail.next;

        if (head == tail) {
            System.out.println(head.data + " Deleted from Beginning.");
            tail = null;
        } else {
            System.out.println(head.data + " Deleted from Beginning.");
            tail.next = head.next;
        }
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is Empty. Can't Delete.");
            return;
        }

        Node head = tail.next;

        if (head == tail) {
            System.out.println(tail.data + " Deleted from End.");
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        System.out.println(tail.data + " Deleted from End.");
        temp.next = tail.next;
        tail = temp;
    }

    public void deleteByValue(int key) {
        if (tail == null) {
            System.out.println("List is Empty. Can't Delete.");
            return;
        }

        Node head = tail.next;

        if (head == tail) {
            if (head.data == key) {
                System.out.println(key + " Deleted from List.");
                tail = null;
            } else {
                System.out.println("Element " + key + " NOT Found!");
            }
            return;
        }

        Node prev = tail;
        Node current = head;
        do {
            if (current.data == key) {
                prev.next = current.next;

                if (current == tail) {
                    tail = prev;
                }

                if (current == head) {
                    tail.next = current.next;
                }

                System.out.println(key + " Deleted from List.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Element " + key + " NOT Found!");
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = tail.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(head)");
    }

    public void search(int key) {
        if (tail == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = tail.next;
        do {
            if (temp.data == key) {
                System.out.println("Element " + key + " Found.");
                return;
            }
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("Element " + key + " NOT Found!");
    }
}

public class CircularLinkedLists {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n--- Circular Linked List Operations Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Delete by Value");
            System.out.println("6. Search");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to Insert at Beginning: ");
                    int frontData = sc.nextInt();
                    cll.insertAtBeginning(frontData);
                    break;

                case 2:
                    System.out.print("Enter element to Insert at End: ");
                    int endData = sc.nextInt();
                    cll.insertAtEnd(endData);
                    break;

                case 3:
                    cll.deleteFromBeginning();
                    break;

                case 4:
                    cll.deleteFromEnd();
                    break;

                case 5:
                    System.out.print("Enter element to Delete: ");
                    int deleteKey = sc.nextInt();
                    cll.deleteByValue(deleteKey);
                    break;

                case 6:
                    System.out.print("Enter element to Search: ");
                    int key = sc.nextInt();
                    cll.search(key);
                    break;

                case 7:
                    cll.display();
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

/*
Sample Output:

--- Circular Linked List Operations Menu ---
1. Insert at Beginning
2. Insert at End
3. Delete from Beginning
4. Delete from End
5. Delete by Value
6. Search
7. Display
8. Exit
Enter your choice: 2
Enter element to Insert at End: 10
10 Inserted at the End.

Enter your choice: 2
Enter element to Insert at End: 20
20 Inserted at the End.

Enter your choice: 5
Enter element to Delete: 10
10 Deleted from List.

Enter your choice: 7
20 -> (head)
*/
