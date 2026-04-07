import java.util.Scanner;
import java.util.Arrays;

public class Uniform_binarysearch {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays return not found (-1).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array: ");
        int size = sc.nextInt();
        if (size < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            sc.close();
            return;
        }
        if (size == 0) {
            System.out.println("Nothing to sort/search");
            runDeterministicDemo();
            sc.close();
            return;
        }
        System.out.println("Enter Array elements in non-decreasing (sorted) order: ");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));

        if (!isSorted(arr)) {
            System.out.println("Invalid input: Uniform Binary Search requires a sorted array in non-decreasing order.");
            runDeterministicDemo();
            sc.close();
            return;
        }

        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();
        int result = binunisearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }

        runDeterministicDemo();
        sc.close();
    }

    public static int binunisearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;
        int[] deltas = buildDeltaTable(n);
        int probe = deltas[0] - 1; // center probe
        probe = Math.max(0, Math.min(n - 1, probe));

        for (int i = 0; i < deltas.length; i++) {
            if (arr[probe] == key) {
                return probe;
            }

            if (i == deltas.length - 1) {
                break;
            }

            int move = deltas[i + 1];
            if (key < arr[probe]) {
                probe -= move;
            } else {
                probe += move;
            }

            // Keep the probe index within valid bounds.
            probe = Math.max(0, Math.min(n - 1, probe));
        }

        return -1;
    }

    private static int[] buildDeltaTable(int n) {
        int[] temp = new int[32];
        int count = 0;
        int delta = (n + 1) / 2;

        while (delta > 0) {
            temp[count++] = delta;
            delta /= 2;
        }

        return Arrays.copyOf(temp, count);
    }

    private static void runDeterministicDemo() {
        int[] demoArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int foundKey = 23;
        int notFoundKey = 24;

        System.out.println("\nDeterministic UBS demonstration");
        System.out.println("Demo array: " + Arrays.toString(demoArr));
        System.out.println("Search key (found case) " + foundKey + " -> index: " + binunisearch(demoArr, foundKey));
        System.out.println("Search key (not-found case) " + notFoundKey + " -> index: " + binunisearch(demoArr, notFoundKey));
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
