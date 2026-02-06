/*
import java.util.Scanner;
public class Bootcamp{
    public static int addnumbers(int a , int b){
        int x = Math.abs((a / 10) % 10);
        int y = Math.abs((b / 10) % 10);
        return x + y;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first digit : ");
        int a = sc.nextInt();
        System.out.println("Enter the second digit : ");
        int b = sc.nextInt();
        int result = addnumbers(a,b);
        System.out.println("The sum of the entered digits are : "+ result);
        sc.close();
    }
}
*//*
import java.util.Scanner;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();
        String result = str1 + str2;
        String rel = shortLongShort(str1,str2);
        System.out.println(rel);
        System.out.println("The cobination of the entered string is : "+ result);
    }
    public static String shortLongShort(String a, String b){
        if(a.length() < b.length()){
            return a + b + a;
        }
        else{
            return b + a + b;
        }
    }
}
*//*
import java.util.Scanner;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();
        String result = combiner(str1,str2);
        System.out.println("The combined string is : "+ result);
        sc.close();
    }
    public static String combiner(String a , String b){
        StringBuilder result = new StringBuilder();
        int s1 = str1.length();
        int s2 = str2.length();
        int minlen = Math.min(s1,s2);
        for(int i = 0; i < minlen; i++){
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }
        if(s1 > minlen){
            result.append(a.substring(minlen));
        }
        else if(s2 > minlen){
        result.append(b.substring(minlen));
        }
        return result.toString();
    }
}
*//*
// Linear search :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[size];
        for(int i = 0 ; i < size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        System.out.println("Enter the key element to be found : ");
        int key = sc.nextInt();
        int result = linearsearch(arr, key);
        if(result != -1){
            System.out.println("Element "+ key +" found at index : "+ result);
        }
        else{
            System.out.println("Element "+ key +" was not found in the entered array.");
        }
    }
    public static int linearsearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
*//*
// Binary Search : 
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[size];
        for(int i = 0 ; i < size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        System.out.println("Enter the key element to be found : ");
        int key = sc.nextInt();
        int result = binarysearch(arr, key);
        if(result != -1){
            System.out.println("Element "+ key +" found at index : "+ result);
        }
        else{
            System.out.println("Element "+ key +" was not found in the entered array.");
        }
    }
    public static int binarysearch(int[] arr, int key){
        int low = 0; 
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key)
                return mid;
            else if(key < arr[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
*//*
// Fibonacci search
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[size];
        for(int i = 0 ; i < size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        System.out.println("Enter the key element to be found : ");
        int key = sc.nextInt();
        int result = fibonaccisearch(arr, key);
        if(result != -1){
            System.out.println("Element "+ key +" found at index : "+ result);
        }
        else{
            System.out.println("Element "+ key +" was not found in the entered array.");
        }
    }
    public static int fibonaccisearch(int[] arr,int key){
        int n = arr.length;
        int fnminus1 = 0;
        int fnminus2 = 1;
        int fn = fnminus1 = fnminus2;
        while(fn < n){
            fnminus2 = fnminus1;
            fnminus1 = fn;
            fn = fnminus1 + fnminus2;
        }
        int offset = -1;
        while(fn > 1){
            int i = Math.min(offset + fnminus2 , n - 1);
            if(arr[i] == key){
                return i;
            }
            else if(arr[i] < key){
                fn = fnminus1;
                fnminus1 = fnminus2;
                fnminus2 = fn - fnminus1;
                offset = i;
            }
            else{
                fn = fnminus2;
                fnminus1 = fnminus1 - fnminus2;
                fnminus2 = fn - fnminus1;
            }
        }
        return -1;
    }
}
*//*
// Uniform Birnary search : 
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[size];
        for(int i = 0 ; i < size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        System.out.println("Enter the key element to be found : ");
        int key = sc.nextInt();
        int result = binunisearch(arr, key);
        if(result != -1){
            System.out.println("Element "+ key +" found at index : "+ result);
        }
        else{
            System.out.println("Element "+ key +" was not found in the entered array.");
        }
    }
    public static int binunisearch(int[] arr, int key){
        int n = arr.length;
        int k = (int)(Math.log(n)/Math.log(2));
        System.out.println("n="+n);
        System.out.println("k="+k);
        int[] offset = new int[k+1];
        offset[0] = 1 << k;
        for(int i = 1; i <= k; i++){
            offset[i] = offset[i-1]/2;
        }
        int index = -1;
        for(int i = 0; i <= k ; i ++){
            int next = index + offset[i];
            if(next < n && arr[next] <= key){
                index = next;                  
             }
        }
        if(index >= 0 && arr[index] == key)
            return index;
        return -1;
    }
}
*//*
// Interpolation search :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[size];
        for(int i = 0 ; i < size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        System.out.println("Enter the key element to be found : ");
        int key = sc.nextInt();
        int result = interpolation(arr, key);
        if(result != -1){
            System.out.println("Element "+ key +" found at index : "+ result);
        }
        else{
            System.out.println("Element "+ key +" was not found in the entered array.");
        }
    }
    public static int interpolation(int[] arr, int key){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        for(int i = 0; i <= n; i++){
            int p = (int)low + ((key - arr[low]) * (high - low))/(arr[high] - arr[low]);
            if(arr[p] == key){
                return p;
            }
            else if(arr[p] < key){
                low = p + 1;
            }
            else{
                low = p - 1;
            }
        }
        return -1;
    }
}
*//*
// Bubble Sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        bubblesort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
*//*
// Insertion sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        insertionsort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void insertionsort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
*//*
// Selection sort:
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        selectionsort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1;i++){
            int min_index = i;
            for(int j = i + 1;j < n;j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
}
*//*
// Quick Sort:
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        quicksortrecursion(arr,0,n-1);
        System.out.println("Sorted Array : "+Arrays.toString(arr));
    }
    public static int partition(int[] arr, int low,int high){
        int pivot = arr[(low + high)/2];
        while(low <= high){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(low <= high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
    public static void quicksortrecursion(int[] arr, int low, int high){
        int pi = partition(arr,low,high);
        if(low < pi-1){
            quicksortrecursion(arr,low,pi-1);
        }
        if(high > pi){
            quicksortrecursion(arr,pi,high);
        }
    }
}
*//*
// Merge Sort : 
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array   : " + Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
*//*
// Radix Sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0 ; i<n;i++ ){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted array : "+Arrays.toString(arr));     
    }
    public static void radixsort(int[] arr){
        int n = arr.length;
        int next;
        for i : arr{
            int next = arr[i]%10;
        }
    }
}
*//*
//Stack :
push : Adds an element to the end of the Stack
pop : Remove an element from the top of the Stack
isempty : Check is the stack is empty
isFull : check if the stack is isFull
peek : displays the top element of the stack
Evaluation of postfix :
> read all the symbols one by one from left to right in the given postfix expression
> If the reading symbol is operand, then push it on to the stack
> If the reading symbol is operand then perform two pop operations and store the two poped operands in two diff 
variables. Then perform reading symbol operation using operand1 and operand2 and push the result back on to the stack.
> Finally perform a pop operation and display the poped value as final result
*//*
import java.util.Scanner;
import java.util.Stack;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix expression : ");
        String postfix = sc.nextLine();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < postfix.length();i++){
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch)){
                s.push(ch - '0');
            }
            else{
                int operand2 = s.pop();
                int operand1 = s.pop();
                int result = 0;
                switch(ch){
                    case'+':result = operand1 + operand2;break;
                    case'-':result = operand1 - operand2;break;
                    case'*':result = operand1 * operand2;break;
                    case'/':result = operand1 / operand2;break;
                }
                s.push(result);
            }
        }
        System.out.println("Result = " + s.pop());
    }
}
*//*
// Stack:
import java.util.Scanner;
public class Bootcamp {
	static int MAX_SIZE = 100;
	static int[] stack = new int[MAX_SIZE];
	static int top = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n--- Stack Operations ---");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter value to push: ");
					int value = sc.nextInt();
					push(value);
					break;
				case 2:
					pop();
					break;
				case 3:
					display();
					break;
				case 4:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} 
        while (choice != 4);
		sc.close();
	}
	static boolean isFull() {
		return top == MAX_SIZE - 1;
	}
	static boolean isEmpty() {
		return top == -1;
	}
	static void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow! Cannot push " + value);
			return;
		}
		stack[++top] = value;
		System.out.println(value + " pushed to stack");
	}
	static int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow! Cannot pop");
			return -1;
		}
		System.out.println(stack[top] + " popped from stack");
		return stack[top--];
	}
	static void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		System.out.print("Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
*//*
//Queue : A queue is a linear data structure that follows first-in first-out principle. 
//linear Queue : 
import java.util.Scanner;
public class Bootcamp{
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    public Bootcamp(int size){
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
        Bootcamp queue = new Bootcamp(capacity);
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
*//*
//Circular Queue:
import java.util.Scanner;
public class Bootcamp{
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    public Bootcamp(int size){
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
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println(item +" enqueued to queue.");
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.Can't dequeue.");
            return;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
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
        Bootcamp queue = new Bootcamp(capacity);
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
*//*
// Linked Lists :
import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Singlylinkedlist {
    private Node head;
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
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
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
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
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty!");
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
    public void search(int key) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + " found at position: " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Element " + key + " not found!");
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
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
public class Bootcamp {
    public static void main(String[] args) {
        Singlylinkedlist list = new Singlylinkedlist();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;
        do {
            System.out.println("\n----- Linked List Operations Menu -----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Search");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at beginning: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
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
                    System.out.print("Enter element to search: ");
                    data = sc.nextInt();
                    list.search(data);
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!!");
            }
        } while (choice != 9);
        sc.close();
    }
}
*//*
// Circular Linked Lists:
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
*//*
//Double Linked List:
import java.util.Scanner;
class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class doublylinkedlist{
    private Node head;
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data +" inserted from beginning");
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            System.out.println(data +" inserted at the end");
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println(data +" inserted at the end");
    }
    public void deleteFromBeginning(){
        if(head == null){
            System.out.println("The List is empty. Can't delete element");
            return;
        }
        System.out.println(head.data +" deleted from front");
        head = head.next;
        if(head != null){
            head.prev = null;
        }
    }
    public void deleteFromEnd(){
        if(head == null){
            System.out.println("The List is empty. Can't delete element");
            return;
        }
        if(head.next == null){
            System.out.println(head.data +" deleted from end");
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.data +" deleted from end");
        temp.prev.next = null;
    }
    public void search(int key){
        if(head == null){
            System.out.println("List is empty!!");
            return;
        }
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println(key + " not found in the list");

    }
    public void displayforward(){
        if(head == null){
            System.out.println("List is empty!!");
            return;
        }
        Node temp = head;
        System.out.println("Forward Traversal : ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displaybackward(){
        if(head == null){
            System.out.println("List is empty!!");
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        System.out.println("Backward Traversal : ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
public class DoubleLinkedList{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        doublylinkedlist dll = new doublylinkedlist();
        int choice, data, position;
        do {
            System.out.println("\n----- Linked List Operations Menu -----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display forward direction");
            System.out.println("7. Display backward direction");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at beginning: ");
                    data = sc.nextInt();
                    dll.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
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
                    System.out.print("Enter element to search: ");
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
                    System.out.println("Invalid choice!!");
            }
        } while (choice != 8);
        sc.close();
    }
}
*/
/*
//Tree :
A tree is a non-linear data structure that consists of nodes connected by edges. It is used to represent 
hierarchial relationships between elements, such as organizational structures, file systems, or expression
parsing.
Types of Trees:
> General Tree:
> Binary Tree:
    - Full binary tree
    - Complete binar tree    
    - Perfect binary tree:
> Binary search tree:
*/
// Binary Tree: