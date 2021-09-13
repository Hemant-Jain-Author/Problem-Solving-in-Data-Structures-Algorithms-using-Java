import java.util.HashMap;
import java.util.HashSet;

public class HashTableExercise {

    public static void main(String[] args) {
        main1();
        main2();
        main3();
        main4();
        main5();
    }

    public static boolean isAnagram(char[] str1, char[] str2) {
        int size1 = str1.length;
        int size2 = str2.length;
        if (size1 != size2)
            return false;
    
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char ch : str1) {
            if (hm.containsKey(ch))
                hm.put(ch, hm.get(ch) + 1);
            else
                hm.put(ch, 1);
        }
    
        for (char ch : str2) {
            if (hm.containsKey(ch) == false || hm.get(ch) == 0)
                return false;
            else
                hm.put(ch, hm.get(ch) - 1);
        }
        return true;
    }
    
    public static void main1() {
        char[] first = "hello".toCharArray();
        char[] second = "elloh".toCharArray();
        char[] third = "world".toCharArray();
    
        System.out.println("isAnagram : " + isAnagram(first, second));
        System.out.println("isAnagram : " + isAnagram(first, third));
    }
    /*
    isAnagram : true
    isAnagram : false
    */
    
    public static String removeDuplicate(char[] str) {
        HashSet<Character> hs = new HashSet<Character>();
        String out = new String();
    
        for (char ch : str) {
            if (hs.contains(ch) == false) {
                out += ch;
                hs.add(ch);
            }
        }
        return out;
    }
    
    public static void main2() {
        char[] first = "hello".toCharArray();
        System.out.println(removeDuplicate(first));
    }
    /*
    helo
    */
    
    public static int findMissing(int[] arr, int start, int end) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : arr) {
            hs.add(i);
        }
    
        for (int curr = start; curr <= end; curr++) {
            if (hs.contains(curr) == false)
                return curr;
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main3() {
        int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
        System.out.println(findMissing(arr, 1, 10));
    }
    /*
    4
    */
    
    public static void printRepeating(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>();
    
        System.out.print("Repeating elements are:");
        for (int val : arr) {
            if (hs.contains(val))
                System.out.print(" " + val);
            else
                hs.add(val);
        }
    }
    public static void main4() {
        int arr1[] = { 1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 1 };
        printRepeating(arr1);
    }
    /*
    Repeating elements are: 4 1
    */
    
    public static void printFirstRepeating(int[] arr) {
        int i;
        int size = arr.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        int firstRepeating = Integer.MAX_VALUE;
    
        for (i = size - 1; i >= 0; i--) {
            if (hs.contains(arr[i])) {
                firstRepeating = arr[i];
            }
            hs.add(arr[i]);
        }
        System.out.println("First Repeating number is:" + firstRepeating);
    }
    
    public static void main5() {
        int arr1[] = { 1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 1 };
        printFirstRepeating(arr1);
    }
    /*
    First Repeating number is:1
    */
    
    public static int hornerHash(char[] key, int tableSize) {
        int size = key.length;
        int h = 0;
        int i;
        for (i = 0; i < size; i++) {
            h = (32 * h + key[i]) % tableSize;
        }
        return h;
    }
}