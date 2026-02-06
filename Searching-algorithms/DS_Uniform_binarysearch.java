// Uniform Birnary search : 
import java.util.Scanner;
import java.util.Arrays;
public class DS_Uniform_binarysearch{
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