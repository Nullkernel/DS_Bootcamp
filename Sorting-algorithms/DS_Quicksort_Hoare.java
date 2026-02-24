// Quick Sort:
import java.util.Scanner;
import java.util.Arrays;
public class DS_Quicksort{
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
