/*
import java.util.*;

public class QuickSortMiddle {

    public static void main(String[] args) {

        int[] arr = {15, 9, 7, 13, 12, 16, 4, 18, 11};
        int length = arr.length;

        QuickSortMiddle qsm = new QuickSortMiddle();
        qsm.quickSortRecursion(arr, 0, length - 1);
        qsm.printArray(arr);
    }

    // Partition method using middle element as pivot
    public int partition(int[] arr, int low, int high) {

        int pivot = arr[low + (high - low) / 2];

        while (low <= high) {

            while (arr[low] < pivot) {
                low++;
            }

            while (arr[high] > pivot) {
                high--;
            }

            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                low++;
                high--;
            }
        }
        return low;
    }

    // Recursive Quick Sort
    public void quickSortRecursion(int[] arr, int low, int high) {

        int pi = partition(arr, low, high);

        if (low < pi - 1) {
            quickSortRecursion(arr, low, pi - 1);
        }

        if (pi < high) {
            quickSortRecursion(arr, pi, high);
        }
    }

    // Print array
    public void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

public class BinarySearchExample {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};
        int key = 8;

        int result = binarySearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    static int binarySearch(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class LinearSearchExample {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};
        int key = 8;

        int result = linearSearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
*/