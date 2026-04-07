import java.util.*;
public class PrefixArray {
    public static int[] computePrefixArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; 
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int[] prefixArray = computePrefixArray(input);
        System.out.println("Prefix Array:");
        System.out.println(Arrays.toString(prefixArray));
    }
}