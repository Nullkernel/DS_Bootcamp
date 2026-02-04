/*
// Linear search :
import java.util.Scanner;
import java.util.Arrays;
public class DS_search{
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
public class DS_search{
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
public class DS_search{
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
        int fn;
        int fnminus1;
        int fnminus2;
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
public class DS_search{
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
public class DS_search{
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
*/