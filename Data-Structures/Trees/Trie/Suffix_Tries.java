import java.util.*;
public class Bootcamp1{
    public static void main(String[] args){
        String word = "banana";
        int n = word.length();
        String arr1[] = new String[n];
        String arr2[] = new String[n];
        ArrayList<Integer> suffix_array = new ArrayList<>();
        for(int i = 0;i < n;i++){
            arr1[i] = word.substring(i);
        }
        arr2 = arr1.clone();
        Arrays.sort(arr1);
        for(String i : arr1){
            String place = i;
            int index = new suffix_array().index(arr2,place);
            suffix_index.add(index);
        }
    }
}