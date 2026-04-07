//Radix sort:
import java.util.Scanner;
import java.util.Arrays;
public class Radixsort {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays are ignored by radix sort.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
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
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (containsNegative(arr)) {
            System.out.println("This radix sort version supports non-negative integers only");
            sc.close();
            return;
        }
        System.out.println("Entered array : " + Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted array : " + Arrays.toString(arr));
        sc.close();
    }
    public static void radixsort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = getMax(arr); 
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static boolean containsNegative(int[] arr) {
        for (int value : arr) {
            if (value < 0) {
                return true;
            }
        }
        return false;
    }
    public static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; 
        int[] count = new int[10]; 
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
