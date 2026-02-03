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
*/
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        int[] arr = new int[100];
        int top = -1;
        boolean isempty(){
            return top == -1;
        }
        boolean isFull(){
            return top == arr.length - 1;
        }
        void push(int data){
            if(isFull()){
                System.out.println("Stack is full");
                return;
            }
            top++;
            arr[top] = data;
            System.out.println(data+" pushed to stack.");s
        }
    }
}