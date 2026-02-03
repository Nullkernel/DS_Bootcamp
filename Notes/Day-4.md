---

---
**--followed from DSA notes--**

# **Bubble Sort:**
	It is one of the simplest sorting algorithms. It works by repeatedly swapping the adjacent elements if they are in the wrong order. this process is repeated until the list is sorted.
	
1. **Algorithm Description:**
	Given an array of n no. of elements, the algorithm performs the following steps:
	
	1) Compare each pair of adjacent elements.
	2) if the current element is greater than the next element swap them.
	3) After each pass, the largest is sorted or "Bubbles up".
	4) it is repeated until the all elements are sorted.
	
2. **Time Complexity:**
	1) Best Case: O(1) - array is already sorted.
	2) Average Case: O(n^2).
	3) Worst Case: O(n^2) - array is in reverse order.
	
3. **Space Complexity:**
	Since it uses the principle of in place sorting, it requires zero extra space.
	
4.  **Code:**
`public class BubbleSort {`
    `public static void bubbleSort(int[] arr) {`
        `int n = arr.length; // use .length (no parentheses)`
        `boolean swapped;`

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        System.out.print("Before: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.print("After:  ");
        printArray(arr);
    }
`}`

# **Insertion Sort:**
It is a simple and intuitive sorting algorithm that builds the sorted array one element at a time. it works by repeatedly taking the next element and inserting it into the correct position in the already sorted part of the array.

 1. **Algorithm Description:**
	1. Start from the second element (index 1), as the first element is considered as sorted.
	2. Compare the current element with the elements in the sorted position. (to it's left).
	3. Shift the current element with the elements in the sorted portion that are greater than the current element to the right by one position.
	4. insert the current element to its current position.
	
2. **Time Complexity:**
	1) Best Case: O(n) - array is already sorted.
	2) Average Case: O(n^2).
	3) Worst Case: O(n^2) - array is in reverse order.
	
3. **Space Complexity:**
	Insertion sort has a space complexity of O(1) because it is an in-place sorting algorithm.
	
4. **Code:**
	`public class InsertionSort {`

    `public static void insertionSort(int[] arr) {`
        `int n = arr.length;`

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    `public static void printArray(int[] arr) {`
        `for (int num : arr) {`
            `System.out.print(num + " ");`
        `}`
        `System.out.println();`
    `}`

    `public static void main(String[] args) {`
        `int[] arr = {5, 3, 8, 4, 2};`

        `System.out.print("Before: ");`
        `printArray(arr);`

        `insertionSort(arr);`

        `System.out.print("After:  ");`
        `printArray(arr);`
    `}`
`}`
# **Selection Sort:**
 It is a simple comparison-based sorting algorithm> It works by repeatedly by finding the minimum element from the unsorted part of the array and swapping it with the first element of the unsorted part.
 
1. **Algorithm Description:**
	1. Start from the **first element** of the array.
	2. **Assume the current position has the smallest element**.
	3. Compare this element with all remaining elements to the right.
	4. If a **smaller element is found**, update the position of the minimum element.
	5. After completing comparisons, **swap** the smallest element with the element at the current position.
	6. Move to the **next position** and repeat the process.
	7. Continue until the entire array is sorted.
	
2. **Time Complexity:**
	1) Best Case: O(n^2).
	2) Average Case: O(n^2).
	3) Worst Case: O(n^2).
	
3. **Space Complexity:**
	Selection sort has a space complexity of O(1) because it is an in-place sorting algorithm.
	
4. **Code:** 
	`public class SelectionSort {`

    `public static void selectionSort(int[] arr) {`
        `int n = arr.length;`

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    `}`

    `public static void printArray(int[] arr) {`
        `for (int num : arr) {`
            `System.out.print(num + " ");`
        `}`
        `System.out.println();`
    `}`

    `public static void main(String[] args) {`
        `int[] arr = {64, 25, 12, 22, 11};`

        System.out.print("Before: ");
        printArray(arr);

        selectionSort(arr);

        System.out.print("After:  ");
        printArray(arr);
    `}`
`}`
