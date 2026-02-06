// Fibonacci search
import java.util.Scanner;
import java.util.Arrays;
public class DS_Fibonaccisearch{
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