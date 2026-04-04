import java.util.Scanner;

public class HashTable {
    static int size;
    static Dataitem[] hasharray;
    static final Dataitem DELETED = new Dataitem(-1, -1);

    static class Dataitem {
        int data;
        int key;

        Dataitem(int data, int key) {
            this.data = data;
            this.key = key;
        }
    }

    static void initialise() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Hash Table: ");
        size = sc.nextInt();
        hasharray = new Dataitem[size];
    }

    static int hashcode(int key) {
        return Math.floorMod(key, size);
    }

    static void insert(int key, int data) {
        Dataitem item = new Dataitem(data, key);
        int hashindex = hashcode(key);
        int startIndex = hashindex;

        while (hasharray[hashindex] != null && hasharray[hashindex] != DELETED) {
            hashindex = (hashindex + 1) % size;
            if (hashindex == startIndex) {
                System.out.println("Hash Table is full. Cannot Insert key: " + key);
                return;
            }
        }
        hasharray[hashindex] = item;
    }

    static Dataitem deleteitem(int key) {
        int hashindex = hashcode(key);
        int startIndex = hashindex;

        while (hasharray[hashindex] != null) {
            if (hasharray[hashindex] != DELETED && hasharray[hashindex].key == key) {
                Dataitem temp = hasharray[hashindex];
                hasharray[hashindex] = DELETED;
                return temp;
            }
            hashindex = (hashindex + 1) % size;
            if (hashindex == startIndex) break;
        }
        return null;
    }

    static void display() {
        for (int i = 0; i < size; i++) {
            if (hasharray[i] != null && hasharray[i] != DELETED) {
                System.out.println("Index " + i +
                        " -> Key: " + hasharray[i].key +
                        ", Data: " + hasharray[i].data);
            } else {
                System.out.println("Index " + i + " -> Empty.");
            }
        }
    }

    public static void main(String[] args) {
        initialise();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Insertions: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the key: ");
            int key = sc.nextInt();
            System.out.print("Enter the element: ");
            int element = sc.nextInt();
            insert(key, element);
        }

        System.out.println("Insertion done!");
        display();
    }
}
