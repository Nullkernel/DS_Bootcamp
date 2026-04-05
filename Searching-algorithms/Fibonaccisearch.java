import java.util.Arrays;
import java.util.Scanner;

public class Fibonaccisearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the Array: ");
        int size = sc.nextInt();

        System.out.println("Enter Array elements: ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();

        int result = fibonacciSearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }

        sc.close();
    }

    public static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;
        int fibMm2 = 0; // (m-2)th Fibonacci number
        int fibMm1 = 1; // (m-1)th Fibonacci number
        int fibM = fibMm1 + fibMm2; // mth Fibonacci number

        while (fibM < n) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm1 + fibMm2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMm2, n - 1);

            if (arr[i] < key) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            } else {
                return i;
            }
        }

        if (fibMm1 == 1 && offset + 1 < n && arr[offset + 1] == key) {
            return offset + 1;
        }

        return -1;
    }
}
