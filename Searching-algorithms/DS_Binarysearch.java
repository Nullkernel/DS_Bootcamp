// Binary Search : 
import java.util.Scanner;
import java.util.Arrays;
public class DS_Binarysearch{
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
