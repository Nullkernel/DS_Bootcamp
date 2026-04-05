import java.util.Scanner;
import java.util.Arrays;

public class Interpolationsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array: ");
        int n = sc.nextInt();
        System.out.println("Enter Array elements: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));
        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();
        int result = interpolationSearch(arr, 0, arr.length - 1, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }
    }
    public static int interpolationSearch(int arr[], int lo, int hi, int x) {
        int pos;
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (arr[lo] == arr[hi]) {
                if (arr[lo] == x)
                    return lo;
                return -1;
            }
            pos = lo + ((hi - lo) * (x - arr[lo])) / (arr[hi] - arr[lo]);
            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi, x);
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1, x);
        }
        return -1;     
    }
}
