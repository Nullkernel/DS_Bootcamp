import java.util.Scanner;

public class HashTable {
    static int size;
    static Dataitem[] hasharray;
    static final Dataitem DELETED = new Dataitem(-1, -1);
    private static final String INVALID_INT_MESSAGE = "Invalid input. Please enter an integer.";

    static class Dataitem {
        int data;
        int key;

        Dataitem(int data, int key) {
            this.data = data;
            this.key = key;
        }
    }

    static void initialise(Scanner sc) {
        size = readPositiveInt(sc, "Enter the size of the Hash Table: ");
        hasharray = new Dataitem[size];
    }

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println(INVALID_INT_MESSAGE);
            sc.next();
        }
    }

    static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Invalid input. Please enter an integer greater than 0.");
        }
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
        Scanner sc = new Scanner(System.in);
        initialise(sc);

        int n = readPositiveInt(sc, "Enter the number of Insertions: ");

        for (int i = 0; i < n; i++) {
            int key = readInt(sc, "Enter the key: ");
            int element = readInt(sc, "Enter the element: ");
            insert(key, element);
        }

        System.out.println("Insertion done!");
        display();
        sc.close();
    }
}
