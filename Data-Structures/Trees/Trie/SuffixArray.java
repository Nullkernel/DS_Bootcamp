import java.util.*;
public class SuffixArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String word = sc.nextLine();
        int n = word.length();
        String[] arr1 = new String[n];
        String[] arr2;
        ArrayList<Integer> suffix_array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1[i] = word.substring(i);
        }
        arr2 = arr1.clone();
        Arrays.sort(arr1);
        for (String s : arr1) {
            for (int i = 0; i < n; i++) {
                if (arr2[i].equals(s)) {
                    suffix_array.add(i);
                    break;
                }
            }
        }
        System.out.println("Suffix Array: " + suffix_array);
    }
}