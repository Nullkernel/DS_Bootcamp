import java.util.Scanner;
import java.util.Arrays;

public class Interpolationsearch {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays return not found (-1).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            sc.close();
            return;
        }
        if (n == 0) {
            System.out.println("Nothing to sort/search");
            sc.close();
            return;
        }
        System.out.println("Enter Array elements in non-decreasing (sorted) order: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));

        if (!isSorted(arr)) {
            System.out.println("Invalid input: Interpolation Search requires a sorted array in non-decreasing order.");
            sc.close();
            return;
        }

        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();
        int result = interpolationSearch(arr, 0, arr.length - 1, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }
        sc.close();
    }
    public static int interpolationSearch(int arr[], int lo, int hi, int x) {
        if (arr == null || arr.length == 0 || lo > hi) {
            return -1;
        }
        int pos;
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (arr[lo] == arr[hi]) {
                if (arr[lo] == x)
                    return lo;
                return -1;
            }
            long numerator = (long) (hi - lo) * (x - arr[lo]);
            long denominator = (long) (arr[hi] - arr[lo]);
            long posLong = lo + (numerator / denominator);
            if (posLong < lo || posLong > hi) {
                return -1;
            }
            pos = (int) posLong;
            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi, x);
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1, x);
        }
        return -1;     
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
