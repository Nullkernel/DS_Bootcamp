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

    static void initialise(int tableSize) {
        size = tableSize;
        hasharray = new Dataitem[size];
    }

    static int hashcode(int key) {
        return Math.floorMod(key, size);
    }

    static void insert(int key, int data) {
        int hashindex = hashcode(key);
        int startIndex = hashindex;
        int firstDeletedIndex = -1;

        while (hasharray[hashindex] != null) {
            if (hasharray[hashindex] == DELETED) {
                if (firstDeletedIndex == -1) {
                    firstDeletedIndex = hashindex;
                }
            } else if (hasharray[hashindex].key == key) {
                hasharray[hashindex].data = data;
                System.out.println("Updated key " + key + " with new data: " + data);
                return;
            }
            hashindex = (hashindex + 1) % size;
            if (hashindex == startIndex) {
                System.out.println("Hash Table is full. Cannot Insert key: " + key);
                return;
            }
        }

        if (firstDeletedIndex != -1) {
            hashindex = firstDeletedIndex;
        }
        hasharray[hashindex] = new Dataitem(data, key);
        System.out.println("Inserted key " + key + " with data: " + data);
    }

    static Dataitem search(int key) {
        int hashindex = hashcode(key);
        int startIndex = hashindex;

        while (hasharray[hashindex] != null) {
            if (hasharray[hashindex] != DELETED && hasharray[hashindex].key == key) {
                System.out.println("Found key " + key + " with data: " + hasharray[hashindex].data);
                return hasharray[hashindex];
            }
            hashindex = (hashindex + 1) % size;
            if (hashindex == startIndex) {
                break;
            }
        }
        System.out.println("Key " + key + " not found.");
        return null;
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
        System.out.println("Cannot delete. Key " + key + " not found.");
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
        initialise(7);

        System.out.println("---- Insert Flow ----");
        insert(1, 100);
        insert(8, 800);
        insert(15, 1500);

        System.out.println("\n---- Update Flow (same key insert) ----");
        insert(8, 8800);
        search(8);

        System.out.println("\n---- Search Flow ----");
        search(15);
        search(99);

        System.out.println("\n---- Delete Flow ----");
        deleteitem(1);
        deleteitem(1);
        search(1);

        System.out.println("\n---- Final Hash Table ----");
        display();
    }
}
