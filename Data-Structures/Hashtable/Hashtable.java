import java.util.Scanner;
public class Hashtable{
    static int size;
    static Dataitem[] hasharray;
    static class Dataitem{
        int data;
        int key;
        Dataitem(int data, int key){
            this.data = data;
            this.key = key;
        }
    }
    static void initialise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the hash table : ");
        size = sc.nextInt();
        hasharray = new Dataitem[size];
    }
    static int hashcode(int key){
        return key % size;
    }
    static void insert(int key,int data){
        Dataitem item = new Dataitem(data,key);
        int hashindex = hashcode(key);
        while(hasharray[hashindex] != null && hasharray[hashindex].key != -1){
            hashindex = (hashindex + 1)% size;
        }
        hasharray[hashindex] = item;
    }
    static Dataitem deleteitem(int key) {
        int hashindex = hashcode(key);
        while (hasharray[hashindex] != null) {
            if (hasharray[hashindex].key == key) {
                Dataitem temp = hasharray[hashindex];
                hasharray[hashindex] = new Dataitem(-1, -1); 
                return temp;
            }
            hashindex = (hashindex + 1) % size;
        }
        return null;
    }
    static void display() {
        for (int i = 0; i < size; i++) {
            if (hasharray[i] != null && hasharray[i].key != -1) {
                System.out.println("Index " + i +
                        " -> Key: " + hasharray[i].key +
                        ", Data: " + hasharray[i].data);
            } else {
                System.out.println("Index " + i + " -> Empty");
            }
        }
    }
    public static void main(String[] args){
        initialise();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of insertions : ");
        int n = sc.nextInt();
        for(int i =0 ; i < n; i++ ){
            System.out.println("Enter the index : ");
            int index = sc.nextInt();
            System.out.println("Enter the element : ");
            int element = sc.nextInt();
            insert(index,element);
        }
        System.out.println("Insertion done !");
        System.out.println();
        display();
    }
}