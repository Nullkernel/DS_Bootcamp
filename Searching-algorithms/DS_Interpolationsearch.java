// Interpolation search :
import java.util.Scanner;
import java.util.Arrays;
public class DS_Interpolationsearch{
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