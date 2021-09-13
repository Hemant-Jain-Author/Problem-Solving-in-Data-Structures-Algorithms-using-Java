import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;;

public class Searching {
    public static boolean linearSearchUnsorted(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean linearSearchSorted(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                return true;
            } else if (value < arr[i]) {
                return false;
            }
        }
        return false;
    }
    
    // Binary Search Algorithm - Iterative Way
    public static boolean binarySearch(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;
        int mid;
    
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    
    //Binary Search Algorithm - Recursive Way
    public static boolean binarySearchRec(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;
        return binarySearchRecUtil(arr, low, high, value);
    }
    
    public static boolean binarySearchRecUtil(int[] arr, int low, int high, int value) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == value) {
            return true;
        } else if (arr[mid] < value) {
            return binarySearchRecUtil(arr, mid + 1, high, value);
        } else {
            return binarySearchRecUtil(arr, low, mid - 1, value);
        }
    }
    
    public static int binarySearch(int[] arr, int start, int end, int key, boolean isInc) {
        int mid;
        if (end < start) {
            return -1;
        }
        mid = (start + end) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (isInc != false && key < arr[mid] || isInc == false && key > arr[mid]) {
            return binarySearch(arr, start, mid - 1, key, isInc);
        } else {
            return binarySearch(arr, mid + 1, end, key, isInc);
        }
    }
    
    public static boolean fibonacciSearch(int[] arr, int size, int value) {
        /* Initialize fibonacci numbers */
        int fibNMn2 = 0; 
        int fibNMn1 = 1; 
        int fibN = fibNMn2 + fibNMn1; 
        
        while (fibN < size) {
            fibNMn2 = fibNMn1;
            fibNMn1 = fibN;
            fibN = fibNMn2 + fibNMn1;
        }

        int low = 0;
        while (fibN > 1) { // fibonacci series start with 0, 1, 1, 2
            int i = Math.min(low + fibNMn2, size-1);
            if (arr[i] == value)
                return true; 
            else if(arr[i] < value) {
                fibN = fibNMn1;
                fibNMn1 = fibNMn2;
                fibNMn2 = fibN - fibNMn1;
                low = i;
            } else { // for feb2 <= 1, these will be invalid.
                fibN = fibNMn2;
                fibNMn1 = fibNMn1 - fibNMn2;
                fibNMn2 = fibN - fibNMn1;
            }
        }
        if(arr[low + fibNMn2] == value)// above loop does not check when fibNMn2 = 0
            return true;
        return false;
    }

    public static void main1() {
        int[] first = { 1, 3, 5, 7, 9, 25, 30 };
    /*    System.out.println(linearSearchUnsorted(first, 7, 8));
        System.out.println(linearSearchSorted(first, 7, 8));
        System.out.println(binarySearch(first, 7, 8));
        System.out.println(binarySearchRec(first, 7, 8));
    
        System.out.println(linearSearchUnsorted(first, 7, 25));
        System.out.println(linearSearchSorted(first, 7, 25));
        System.out.println(binarySearch(first, 7, 25));
        System.out.println(binarySearchRec(first, 7, 25));
*/
    for(int i=0;i<32;i++)        
        System.out.println(i + " : " + fibonacciSearch(first, 7, i));
    }
    /*
    false
    false
    false
    false
    
    true
    true
    true
    true
    */
    
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
    public static int firstRepeated(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return 0;
    }

    public static int firstRepeated2(int[] arr, int size) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();    

        for (int i = 0; i < size; i++) {
            if(hm.containsKey(arr[i]))
                hm.put(arr[i], 2);
            else 
                hm.put(arr[i], 1);
        }

        for (int i = 0; i < size; i++) {
            if (hm.get(arr[i]) == 2) {
                return arr[i];
            }
        }
        return 0;
    }
    

    public static void main2() {
        int[] first = {1, 3, 5, 3, 9, 1, 30 };
        System.out.println(firstRepeated(first, first.length));
        System.out.println(firstRepeated2(first, first.length));

    }
    /*
    1
    */
    
    public static void printRepeating(int[] arr, int size) {
        System.out.print("Repeating elements are ");
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(" " + arr[i]);
                }
            }
        }
        System.out.println();
    }
    
    public static void printRepeating2(int[] arr, int size) {
        Arrays.sort(arr);
        System.out.print("Repeating elements are ");
    
        for (int i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1]) {
                System.out.print(" " + arr[i]);
            }
        }
        System.out.println();
    }
    
    public static void printRepeating3(int[] arr, int size) {
        HashSet<Integer> hs = new HashSet<Integer>();
        System.out.print("Repeating elements are ");
        for (int i = 0; i < size; i++) {
            if (hs.contains(arr[i])) {
                System.out.print(" " + arr[i]);
            } else {
                hs.add(arr[i]);
            }
        }
        System.out.println();
    }
    
    public static void printRepeating4(int[] arr, int size, int range) {
        int[] count = new int[range];
        int i;
        for (i = 0; i < size; i++) {
            count[i] = 0;
        }
        System.out.print("Repeating elements are ");
        for (i = 0; i < size; i++) {
            if (count[arr[i]] == 1) {
                System.out.print(" " + arr[i]);
            } else {
                count[arr[i]]++;
            }
        }
        System.out.println();
    }
    
    public static void main3() {
        int[] first = { 1, 3, 5, 3, 9, 1, 30 };
        printRepeating(first, first.length);
        printRepeating2(first, first.length);
        printRepeating3(first, first.length);
        printRepeating4(first, first.length, 50);
    }
    /*
    Repeating elements are  1 3
    Repeating elements are  1 3
    Repeating elements are  1 3
    Repeating elements are  1 3
    */
    
    public static int[] removeDuplicates(int[] array, int size) {
        int j = 0;
        Arrays.sort(array);
        for (int i = 1; i < size; i++) {
            if (array[i] != array[j]) {
                j++;
                array[j] = array[i];
            }
        }
        int[] ret = Arrays.copyOf(array, j + 1);
        return ret;
    }
    
    public static int[] removeDuplicates2(int[] arr, int size) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();    
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!hm.containsKey(arr[i])) {
                arr[j] = arr[i];
                j++;
                hm.put(arr[i], 1);
            }
        }
        int[] ret = Arrays.copyOf(arr, j);
        return ret;
    }

    public static void main4() {
        int[] first = { 1, 3, 5, 3, 9, 1, 30 };
        int[] ret = removeDuplicates(first, first.length);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();

        int[] first2 = { 1, 3, 5, 3, 9, 1, 30 };
        int[] ret2 = removeDuplicates2(first2, first2.length);
        for (int i = 0; i < ret2.length; i++) {
            System.out.print(ret2[i] + " ");
        }
        System.out.println();
    }
    /*
    1 3 5 9 30 
    */
    
    public static int findMissingNumber(int[] arr, int size) {
        int i, j, found = 0;
        for (i = 1; i <= size; i++) {
            found = 0;
            for (j = 0; j < size; j++) {
                if (arr[j] == i) {
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public static int findMissingNumber2(int[] arr, int size) {
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            if (arr[i] != i+1)
                return i+1;
        }
        return size;
    }

    public static int findMissingNumber3(int[] arr, int size) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++)
            hm.put(arr[i], 1);
            
        for(int i = 1; i<= size; i++)
            if(!hm.containsKey(i))
                return i;
        
        return Integer.MAX_VALUE;
    }

    public static int findMissingNumber4(int[] arr, int size) {
        int[] count = new int[size+1];
        Arrays.fill(count, -1);
        for (int i = 0; i < size; i++)
            count[arr[i]-1] = 1;
            
        for(int i = 0; i<= size; i++)
            if(count[i] == -1)
                return i+1;
        
        return Integer.MAX_VALUE;
    }

    public static int findMissingNumber5(int[] arr, int size) {
        int sum =0;
        // Element value range is from 1 to size+1.
        for (int i = 1; i < (size+2); i++)
            sum += i;
        for(int i = 0; i< size; i++)
            sum -= arr[i];
        return sum;
    }

    public static int findMissingNumber6(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            arr[(arr[i])%(size) - 1] += size+1;
        
        for(int i = 0; i< size; i++)
            if(arr[i] < size+1)
                return i+1;
        return Integer.MAX_VALUE;
    }

    public static int findMissingNumber7(int[] arr, int size) {
        int i;
        int xorSum = 0;
        // Element value range is from 1 to size+1.
        for (i = 1; i < (size+2); i++) {
            xorSum ^= i;
        }
        // loop through the array and get the XOR of elements
        for (i = 0; i < size; i++) {
            xorSum ^= arr[i];
        }
        return xorSum;
    }
    
    public static int findMissingNumber8(int[] arr, int size) {
        HashSet<Integer> st = new HashSet<Integer>();
        int i = 0;
        while (i < size) {
            st.add(arr[i]);
            i += 1;
        }
        i = 1;
        while (i <= size) {
            if (st.contains(i) == false)
                return i;
            i += 1;
        }
        System.out.println("NoNumberMissing");
        return -1;
    }
    
    public static void main5() {
        int[] first = {1, 5, 4, 3, 2, 7, 8, 9};
        System.out.println(findMissingNumber(first, first.length));
        System.out.println(findMissingNumber2(first, first.length));
        System.out.println(findMissingNumber3(first, first.length));
        System.out.println(findMissingNumber4(first, first.length));
        System.out.println(findMissingNumber5(first, first.length));
        System.out.println(findMissingNumber7(first, first.length));
        System.out.println(findMissingNumber8(first, first.length));
        System.out.println(findMissingNumber6(first, first.length));

    }
    /*
    6
    6
    6
    */
    

    public static void missingValues(int[] arr, int size) {
        int max = arr[0];
        int min = arr[0];
        for (int i=1; i < size; i++) {
            if (max < arr[i])
                max = arr[i];

            if(min > arr[i])
                min = arr[i];
        }
        boolean found;
        for (int i=min+1; i < max; i++) {
            found = false;
            for(int j=0;j< size; j++){
                if(arr[j] == i){
                    found = true;
                    break;
                }
            }
            if(!found)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void missingValues2(int[] arr, int size) {
        Arrays.sort(arr);
        int value = arr[0];
        int i = 0;
        while (i < size) {
            if (value == arr[i]) {
                value += 1;
                i += 1;
            } else {
                System.out.print(value + " ");
                value += 1;
            }
        }
        System.out.println();
    }
    
    public static void missingValues3(int[] arr, int size) {
        HashSet<Integer> ht = new HashSet<Integer>();
        int minVal = 999999;
        int maxVal = -999999;
    
        for (int i = 0; i < size; i++) {
            ht.add(arr[i]);
            if (minVal > arr[i])
                minVal = arr[i];
            if (maxVal < arr[i])
                maxVal = arr[i];
        }
        for (int i = minVal; i < maxVal + 1; i++) {
            if (ht.contains(i) == false) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    public static void main6() {
        int[] arr = {11, 14, 13, 17, 21, 18, 19, 23, 24};
        int size = arr.length;
        missingValues(arr, size);
        missingValues2(arr, size);
        missingValues3(arr, size);

    }
    /*
    12 15 16 20 22 
    12 15 16 20 22 
    */
    
    public static void oddCount(int[] arr, int size) {
        int xorSum = 0;
        for (int i = 0; i < size; i++) {
            xorSum ^= arr[i];
        }
        System.out.println("Odd values: " + xorSum);
    }

    public static void oddCount2(int[] arr, int size) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (hm.containsKey(arr[i]))
                hm.remove(arr[i]);
            else
                hm.put(arr[i], 1);
        }
        System.out.print("Odd values: ");
        for(Integer key : hm.keySet())
            System.out.print(key+ " ");
        System.out.println();

        System.out.println("Odd count is :: " + hm.size());
    }
    
    public static void oddCount3(int[] arr, int size) {
        int xorSum = 0;
        int first = 0;
        int second = 0;
        int setBit;
        /*
         * xor of all elements in arr[] even occurrence will cancel each other. sum will
         * contain sum of two odd elements.
         */
        for (int i = 0; i < size; i++)
            xorSum = xorSum ^ arr[i];
    
        /* Rightmost set bit. */
        setBit = xorSum & ~(xorSum - 1);
    
        /*
         * Dividing elements in two group: Elements having setBit bit as 1. Elements
         * having setBit bit as 0. Even elements cancelled themselves if group and we
         * get our numbers.
         */
        for (int i = 0; i < size; i++) {
            if ((arr[i] & setBit) != 0)
                first ^= arr[i];
            else
                second ^= arr[i];
        }
        System.out.println("Odd values: " + first + " " + second);
    }
    
    public static void main7() {
        int[] arr = {10, 25, 30, 10, 15, 25, 15};
        int size = arr.length;
        oddCount(arr, size);
        oddCount2(arr, size);
        int[] arr2 = {10, 25, 30, 10, 15, 25, 15, 40};
        int size2 = arr2.length;
        oddCount3(arr2, size2);
    }
    /*
    30 40 
    Odd count is :: 2
    30 40
    */
    
    public static void sumDistinct(int[] arr, int size) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < (size - 1); i++) {
            if (arr[i] != arr[i + 1])
                sum += arr[i];
        }
        sum += arr[size - 1];
        System.out.println("sum : " + sum);
    }
    
    public static void main8() {
        int[] arr = {1, 2, 3, 1, 1, 4, 5, 6};
        int size = arr.length;
        sumDistinct(arr, size);
    }
    /*
    sum : 21
    */
    
    public static void minAbsSumPair(int[] arr, int size) {
        int l, r, minSum, sum, minFirst, minSecond;
        // Array should have at least two elements
        if (size < 2) {
            System.out.println("Invalid Input");
            return;
        }
        // Initialization of values
        minFirst = 0;
        minSecond = 1;
        minSum = Math.abs(arr[0] + arr[1]);
        for (l = 0; l < size - 1; l++) {
            for (r = l + 1; r < size; r++) {
                sum = Math.abs(arr[l] + arr[r]);
                if (sum < minSum) {
                    minSum = sum;
                    minFirst = l;
                    minSecond = r;
                }
            }
        }
        System.out.println("Minimum sum elements are : " + arr[minFirst] + " , " + arr[minSecond]);
    }
    
    public static void minAbsSumPair2(int[] arr, int size) {
        int l, r, minSum, sum, minFirst, minSecond;
        // Array should have at least two elements
        if (size < 2) {
            System.out.println("Invalid Input");
            return;
        }
        Arrays.sort(arr);
    
        // Initialization of values
        minFirst = 0;
        minSecond = size - 1;
        minSum = Math.abs(arr[minFirst] + arr[minSecond]);
        for (l = 0, r = size - 1; l < r;) {
            sum = (arr[l] + arr[r]);
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                minFirst = l;
                minSecond = r;
            }
            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                break;
            }
        }
        System.out.println("Minimum sum elements are : " + arr[minFirst] + " , " + arr[minSecond]);
    }
    
    public static void main9() {
        int[] first = { 1, 5, -10, 3, 2, -6, 8, 9, 6 };
        minAbsSumPair2(first, first.length);
        minAbsSumPair(first, first.length);
    
    }
    /*
    Minimum sum elements are : -6 , 6
    Minimum sum elements are : -6 , 6
    */
    
    public static boolean findPair(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((arr[i] + arr[j]) == value) {
                    System.out.println("The pair is : " + arr[i] + ", " + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findPair2(int[] arr, int size, int value) {
        int first = 0, second = size - 1;
        int curr;
        Arrays.sort(arr);
        while (first < second) {
            curr = arr[first] + arr[second];
            if (curr == value) {
                System.out.println("The pair is " + arr[first] + ", " + arr[second]);
                return true;
            } else if (curr < value) {
                first++;
            } else {
                second--;
            }
        }
        return false;
    }
    
    public static boolean findPair3(int[] arr, int size, int value) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            if (hs.contains(value - arr[i])) {
                System.out.println("The pair is : " + arr[i] + ", " + (value - arr[i]));
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }
    
public static boolean findPair4(int[] arr, int size, int range, int value) {
    int[] count = new int[range+1];
    Arrays.fill(count, 0);
    for (int i = 0; i < size; i++) {
        if (count[value - arr[i]] > 0) {
            System.out.println("The pair is : " + arr[i] + ", " + (value - arr[i]));
            return true;
        }
        count[arr[i]] += 1;
    }
    return false;
}

    public static void main10() {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        System.out.println(findPair(first, first.length, 8));
        System.out.println(findPair2(first, first.length, 8));
        System.out.println(findPair3(first, first.length, 8));
        System.out.println(findPair4(first, first.length, 9, 8));
    }
    /*
    The pair is : 1, 7
    true
    The pair is 1, 7
    true
    The pair is : 5, 3
    true
    The pair is : 5, 3
    true
    */


    public static boolean findPairTwoLists(int[] arr1, int size1, 
                    int[] arr2, int size2, int value) {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if ((arr1[i] + arr2[j]) == value) {
                    System.out.println("The pair is : " + arr1[i] + ", " + arr2[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findPairTwoLists2(int[] arr1, int size1, 
                        int[] arr2, int size2, int value) {    
        Arrays.sort(arr2);
        for(int i=0; i<size1; i++){
            if(binarySearch(arr2, size2, value - arr1[i]))
                System.out.println("The pair is " + arr1[i] + ", " + (value - arr1[i]));
            return true;
        }
        return false;
    }

    public static boolean findPairTwoLists3(int[] arr1, int size1, 
                                    int[] arr2, int size2, int value) {
        int first = 0, second = size2 - 1, curr=0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (first < size1 && second >= 0) {
            curr = arr1[first] + arr2[second];
            if (curr == value) {
                System.out.println("The pair is " + arr1[first] + ", " + arr2[second]);
                return true;
            } else if (curr < value) {
                first++;
            } else {
                second--;
            }
        }
        return false;
    }


    public static boolean findPairTwoLists4(int[] arr1, int size1, 
                                    int[] arr2, int size2, int value) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < size2; i++)
            hs.add(arr2[i]);

        for (int i = 0; i < size1; i++) {
            if (hs.contains(value - arr1[i])) {
                System.out.println("The pair is : " + arr1[i] + ", " + (value - arr1[i]));
                return true;
            }
        }
        return false;
    }

    public static boolean findPairTwoLists5(int[] arr1, int size1, 
                                int[] arr2, int size2, int range, int value) {
        int[] count = new int[range+1];
        Arrays.fill(count, 0);

        for (int i = 0; i < size2; i++)
            count[arr2[i]] = 1;

        for (int i = 0; i < size1; i++) {
            if (count[value - arr1[i]] != 0) {
                System.out.println("The pair is : " + arr1[i] + ", " + (value - arr1[i]));
                return true;
            }
        }
        return false;
    }

    public static void main10A() {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        int[] second = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        System.out.println(findPairTwoLists(first, first.length, second, second.length, 8));
        System.out.println(findPairTwoLists2(first, first.length, second, second.length, 8));
        System.out.println(findPairTwoLists3(first, first.length, second, second.length, 8));
        System.out.println(findPairTwoLists4(first, first.length, second, second.length, 8));
        System.out.println(findPairTwoLists5(first, first.length, second, second.length, 9, 8));
    }

/*
The pair is : 1, 7
true
The pair is 1, 7
true
The pair is 1, 7
true
The pair is : 1, 7
true
The pair is : 1, 7
true    */



    public static boolean findDifference(int arr[], int size, int value) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(arr[i] - arr[j]) == value) {
                    System.out.println("The pair is:: " + arr[i] + " & " + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findDifference2(int arr[], int size, int value) {
        int first = 0;
        int second = 0;
        int diff;
        Arrays.sort(arr);
        while (first < size && second < size) {
            diff = Math.abs(arr[first] - arr[second]);
            if (diff == value) {
                System.out.println("The pair is::" + arr[first] + " & " + arr[second]);
                return true;
            } else if (diff > value)
                first += 1;
            else
                second += 1;
        }
        return false;
    }
    public static void main11() {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        System.out.println(findDifference(first, first.length, 6));
        System.out.println(findDifference2(first, first.length, 6));
    }
    /*
    The pair is:: 1 & 7
    true
    The pair is::1 & 7
    true
    */
    
    public static int findMinDiff(int arr[], int size) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int value = Math.abs(arr[i] - arr[j]); 
                if ( diff > value)
                    diff = value;
            }
        }
        return diff;
    }

    public static int findMinDiff2(int[] arr, int size) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
    
        for (int i = 0; i < (size - 1); i++) {
            if ((arr[i + 1] - arr[i]) < diff)
                diff = arr[i + 1] - arr[i];
        }
        return diff;
    }

    public static void main12() {
        int[] second = {1, 6, 4, 19, 17, 20};
        System.out.println("findMinDiff : " + findMinDiff(second, second.length));
        System.out.println("findMinDiff : " + findMinDiff2(second, second.length));
    }
    /*
    findMinDiff : 1
    */
    public static int minDiffPair(int arr1[], int size1, int arr2[], int size2) {
        int diff = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                int value = Math.abs(arr1[i] - arr2[j]); 
                if ( diff > value){
                    diff = value;
                    first = arr1[i];
                    second = arr2[j];
                }
            }
        }
        System.out.println("The pair is :: " + first + " & " + second);
        System.out.println("Minimum difference is :: " + diff);
        return diff;
    }


    public static int minDiffPair2(int arr1[], int size1, int arr2[], int size2) {
        int minDiff = Integer.MAX_VALUE;
        int  i = 0;
        int  j = 0;
        int first = 0, second = 0, diff;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < size1 && j < size2) {
            diff = Math.abs(arr1[i] - arr2[j]);
            if (minDiff > diff) {
                minDiff = diff;
                first = arr1[i];
                second = arr2[j];
            }
            if (arr1[i] < arr2[j])
                i += 1;
            else
                j += 1;
        }
        System.out.println("The pair is :: " + first + " & " + second);
        System.out.println("Minimum difference is :: " + minDiff);
        return minDiff;
    }
    
    public static void main13() {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        int[] second = {6, 4, 19, 17, 20};
        minDiffPair(first, first.length, second, second.length);
        minDiffPair(first, first.length, second, second.length);

    }
    /*
    The pair is :: 4 4
    Minimum difference is :: 0
    */
    
    public static void closestPair(int arr[], int size, int value) {
        int diff = 999999;
        int first = -1;
        int second = -1;
        int curr;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                curr = Math.abs(value - (arr[i] + arr[j]));
                if (curr < diff) {
                    diff = curr;
                    first = arr[i];
                    second = arr[j];
                }
            }
        }
        System.out.println("closest pair is :: " + first + " " + second);
    }
    
    public static void closestPair2(int arr[], int size, int value) {
        int first = 0, second = 0;
        int start = 0;
        int stop = size - 1;
        int diff, curr;
        Arrays.sort(arr);
        diff = 9999999;
        {
            while (start < stop) {
                curr = (value - (arr[start] + arr[stop]));
                if (Math.abs(curr) < diff) {
                    diff = Math.abs(curr);
                    first = arr[start];
                    second = arr[stop];
                }
                if (curr == 0) {
                    break;
                } else if (curr > 0) {
                    start += 1;
                } else {
                    stop -= 1;
                }
            }
        }
        System.out.println("closest pair is :: " + first + " " + second);
    }
    
    public static void main14() {
        int[] first = { 10, 20, 3, 4, 50, 80 };
        closestPair(first, first.length, 47);
        closestPair2(first, first.length, 47);
    }
    /*
    closest pair is :: 3 50
    closest pair is :: 3 50
    */
    
    public static boolean sumPairRestArray(int[] arr, int size) {
        int total, low, high, curr, value;
        Arrays.sort(arr);
        total = 0;
        for (int i = 0; i < size; i++)
            total += arr[i];
        value = total / 2;
        low = 0;
        high = size - 1;
        while (low < high) {
            curr = arr[low] + arr[high];
            if (curr == value) {
                System.out.println("Pair is :: " + arr[low] + " " + arr[high]);
                return true;
            } else if (curr < value)
                low += 1;
            else
                high -= 1;
        }
        return false;
    }
    
    public static void main15() {
        int[] first = {1, 2, 4, 8, 16, 15};
        System.out.println(sumPairRestArray(first, first.length));
    }
    /*
    Pair is :: 8 15
    true
    */
    
    public static void zeroSumTriplets(int[] arr, int size) {
        for (int i = 0; i < (size - 2); i++) {
            for (int j = i + 1; j < (size - 1); j++) {
                for (int k = j + 1; k < size; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0)
                        System.out.println("Triplet:: " + arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }
    }
    
    public static void zeroSumTriplets2(int[] arr, int size) {
        int start, stop;
        Arrays.sort(arr);
        for (int i = 0; i < (size - 2); i++) {
            start = i + 1;
            stop = size - 1;
    
            while (start < stop) {
                if (arr[i] + arr[start] + arr[stop] == 0) {
                    System.out.println("Triplet :: " + arr[i] + " " + arr[start] + " " + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if (arr[i] + arr[start] + arr[stop] > 0)
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }
    
    public static void main16() {
        int[] first = {0, -1, 2, -3, 1};
        zeroSumTriplets(first, first.length);
        zeroSumTriplets2(first, first.length);
    }
    /*
    Triplet:: 0 -1 1
    Triplet:: 2 -3 1
    Triplet :: -3 1 2
    Triplet :: -1 0 1
    */
    
    public static void findTriplet(int arr[], int size, int value) {
        for (int i = 0; i < (size - 2); i++)
            for (int j = i + 1; j < (size - 1); j++)
                for (int k = j + 1; k < size; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == value)
                        System.out.println("Triplet :: " + arr[i] + " " + arr[j] + " " + arr[k]);
                }
    }
    
    public static void findTriplet2(int arr[], int size, int value) {
        int start, stop;
        Arrays.sort(arr);
        for (int i = 0; i < size - 2; i++) {
            start = i + 1;
            stop = size - 1;
            while (start < stop) {
                if (arr[i] + arr[start] + arr[stop] == value) {
                    System.out.println("Triplet ::" + arr[i] + " " + arr[start] + " " + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if (arr[i] + arr[start] + arr[stop] > value)
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }

    public static void main17() {
        int[] first = {1, 5, 15, 6, 9, 8};
        findTriplet(first, first.length, 22);
        findTriplet2(first, first.length, 22);
    }
    /*
    Triplet :: 1 15 6
    Triplet :: 5 9 8
    Triplet ::1 6 15
    Triplet ::5 8 9
    */
    

    public static void abcTriplet(int[] arr, int size) {
        for (int i = 0; i < size-1; i++)
        for (int j = i + 1; j < size; j++)
            for (int k = 0; k < size; k++) {
                if ( k != i && k != j && arr[i] + arr[j] == arr[k])
                    System.out.println("abcTriplet:: " + arr[i] + " " + arr[j] + " " + arr[k]);
            }
    }

    public static void abcTriplet2(int[] arr, int size) {
        int start, stop;
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            start = 0;
            stop = size - 1;
            while (start < stop) {
                if (arr[i] == arr[start] + arr[stop]) {
                    System.out.println("abcTriplet:: " + arr[start] + " " + arr[stop] + " " + arr[i]) ;
                    start += 1;
                    stop -= 1;
                } else if (arr[i] < arr[start] + arr[stop])
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }
    
    public static void main18() {
        int[] first = {1, 5, 15, 6, 9, 8};
        abcTriplet(first, first.length);
        abcTriplet2(first, first.length);
    }
    
    /*
    abcTriplet:: 1 5 6
    abcTriplet:: 1 8 9
    abcTriplet:: 6 9 15
    */
    
    public static void smallerThenTripletCount(int arr[], int size, int value) {
        int count = 0;
        for (int i = 0; i < size-1; i++)
        for (int j = i + 1; j < size; j++)
        for (int k = j + 1; k < size; k++)
            if (arr[i] + arr[j] + arr[k] < value )
                count += 1;
        System.out.println("smallerThenTripletCount:: " + count);
    }

    public static void smallerThenTripletCount2(int arr[], int size, int value) {
        int start, stop;
        int count = 0;
        Arrays.sort(arr);
    
        for (int i = 0; i < (size - 2); i++) {
            start = i + 1;
            stop = size - 1;
            while (start < stop) {
                if (arr[i] + arr[start] + arr[stop] >= value)
                    stop -= 1;
                else {
                    count += stop - start;
                    start += 1;
                }
            }
        }
        System.out.println("smallerThenTripletCount:: " + count);
    }
    
    public static void main19() {
        int[] first = {-2, -1,  0, 1};
        smallerThenTripletCount(first, first.length, 2);
        smallerThenTripletCount(first, first.length, 2);
    }
    /*
    4
    4
    */
    
    public static void apTriplets(int[] arr, int size) {
        int i, j, k;
        for (i = 1; i < size - 1; i++) {
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < size) {
                if (arr[j] + arr[k] == 2 * arr[i]) {
                    System.out.println("AP Triplet:: " + arr[j] + " " + arr[i] + " " + arr[k]);
                    k += 1;
                    j -= 1;
                } else if (arr[j] + arr[k] < 2 * arr[i])
                    k += 1;
                else
                    j -= 1;
            }
        }
    }
    
    public static void main20() {
        int[] arr = { 2, 4, 10, 12, 14, 18, 36};
        apTriplets(arr, arr.length);
    }
    /*
    AP Triplet:: 2 10 18
    AP Triplet:: 10 12 14
    AP Triplet:: 10 14 18
    */
    
    public static void gpTriplets(int[] arr, int size) {
        int i, j, k;
        for (i = 1; i < size - 1; i++) {
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < size) {
                if (arr[j] * arr[k] == arr[i] * arr[i]) {
                    System.out.println("GP Triplet:: " + arr[j] + " " + arr[i] + " " + arr[k]);
                    k += 1;
                    j -= 1;
                } else if (arr[j] + arr[k] < 2 * arr[i])
                    k += 1;
                else
                    j -= 1;
            }
        }
    }
    
    public static void main21() {
        int[] arr = {1, 2, 4, 8, 16};
        gpTriplets(arr, arr.length);
    }
    /*
    GP Triplet:: 1 2 4
    GP Triplet:: 2 4 8
    GP Triplet:: 1 4 16
    GP Triplet:: 4 8 16
    */
    
    public static int numberOfTriangles(int[] arr, int size) {
        int i, j, k, count = 0;
        for (i = 0; i < (size - 2); i++) {
            for (j = i + 1; j < (size - 1); j++) {
                for (k = j + 1; k < size; k++) {
                    if (arr[i] + arr[j] > arr[k])
                        count += 1;
                }
            }
        }
        return count;
    }
    
    public static int numberOfTriangles2(int[] arr, int size) {
        int i, j, k, count = 0;
        Arrays.sort(arr);
    
        for (i = 0; i < (size - 2); i++) {
            k = i + 2;
            for (j = i + 1; j < (size - 1); j++) {
                /*
                 * if sum of arr[i] & arr[j] is greater arr[k] then sum of arr[i] & arr[j + 1]
                 * is also greater than arr[k] this improvement make algo O(n2)
                 */
                while (k < size && arr[i] + arr[j] > arr[k])
                    k += 1;
    
                count += k - j - 1;
            }
        }
        return count;
    }
    
    public static void main22() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(numberOfTriangles(arr, arr.length));
        System.out.println(numberOfTriangles2(arr, arr.length));
    }
    /*
    3
    3
    */
    
    public static int getMax(int[] arr, int size) {
        int max = arr[0], count = 1, maxCount = 1;
        for (int i = 0; i < size; i++) {
            count = 1;
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        }
        return max;
    }
    
    public static int getMax2(int[] arr, int size) {
        int max = arr[0], maxCount = 1;
        int curr = arr[0], currCount = 1;
        Arrays.sort(arr); // Sort(arr,size);
        for (int i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1]) {
                currCount++;
            } else {
                currCount = 1;
                curr = arr[i];
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                max = curr;
            }
        }
        return max;
    }
    
    public static int getMax3(int[] arr, int size, int range) {
        int max = arr[0], maxCount = 1;
        int[] count = new int[range];
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
            if (count[arr[i]] > maxCount) {
                maxCount = count[arr[i]];
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main23() {
        int[] first = { 1, 30, 5, 13, 9, 31, 5 };
        System.out.println(getMax(first, first.length));
        System.out.println(getMax2(first, first.length));
        System.out.println(getMax3(first, first.length, 50));
    }
    /*
    5
    5
    5
    */
    
    public static int getMajority(int[] arr, int size) {
        int max = 0, count = 0, maxCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        }
        if (maxCount > size / 2) {
            return max;
        } else {
            return 0;
        }
    }
    
    public static int getMajority2(int[] arr, int size) {
        int majIndex = size / 2, count = 1;
        int candidate;
        Arrays.sort(arr); 
        candidate = arr[majIndex];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }
        if (count > size / 2) {
            return arr[majIndex];
        } else {
            return Integer.MIN_VALUE;
        }
    }
    
    public static int getMajority3(int[] arr, int size) {
        int majIndex = 0, count = 1;
        int i;
        int candidate;
        for (i = 1; i < size; i++) {
            if (arr[majIndex] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }
        candidate = arr[majIndex];
        count = 0;
        for (i = 0; i < size; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }
        if (count > size / 2) {
            return arr[majIndex];
        } else {
            return 0;
        }
    }
    
    public static void main24() {
        int[] first = { 1, 5, 5, 13, 5, 31, 5 };
        System.out.println(getMajority(first, first.length));
        System.out.println(getMajority2(first, first.length));
        System.out.println(getMajority3(first, first.length));
    }
    /*
    5
    5
    5
    */
    


    public static int getMedian(int[] arr, int size) {
        Arrays.sort(arr);
        return arr[size / 2];
    }

    public static int getMedian2(int[] arr, int size) {
        quickSelectUtil(arr, 0, size - 1, size/2);
        return arr[size / 2];
    }

    public static void main25() {
        int[] first = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        System.out.println(getMedian(first, first.length));
        System.out.println(getMedian(first, first.length));
    }
    /*
    6
    */
    

    public static int searchBitonicArrayMax(int[] arr, int size) {
        for(int i = 0; i < size-2; i++){
            if(arr[i] > arr[i+1])
                return arr[i];
        }
        System.out.println("error not a bitonic array");
        return 0;
    }

    public static int searchBitonicArrayMax2(int[] arr, int size) {
        int start = 0, end = size - 1;
        int mid = (start + end) / 2;
        int maximaFound = 0;
        if (size < 3) {
            System.out.println("error");
            return 0;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])// maxima
            {
                maximaFound = 1;
                break;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])// increasing
            {
                start = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])// decreasing
            {
                end = mid - 1;
            } else {
                break;
            }
        }
        if (maximaFound == 0) {
            System.out.println("error not a bitonic array");
            return 0;
        }
        return arr[mid];
    }
    
    public static int searchBitonicArray(int[] arr, int size, int key) {
        int max = findMaxBitonicArray(arr, size);
        int k = binarySearch(arr, 0, max, key, true);
        if (k != -1) {
            return k;
        } else {
            return binarySearch(arr, max + 1, size - 1, key, false);
        }
    }
    
    public static int findMaxBitonicArray(int[] arr, int size) {
        int start = 0, end = size - 1, mid;
        if (size < 3) {
            System.out.println("error");
            return -1;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])// maxima
            {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])// increasing
            {
                start = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])// increasing
            {
                end = mid - 1;
            } else {
                break;
            }
        }
        System.out.println("error");
        return -1;
    }
    
    public static void main26() {
        int[] first = { 1, 5, 10, 13, 20, 30, 8, 7, 6 };
        System.out.println(searchBitonicArrayMax(first, first.length));
        System.out.println(searchBitonicArrayMax2(first, first.length));
        System.out.println(searchBitonicArray(first, first.length, 7));
    }
    /*
    30
    7
    */
    
    public static int findKeyCount(int[] arr, int size, int key) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                count++;
            }
        }
        return count;
    }
    
    public static int findFirstIndex(int[] arr, int start, int end, int key) {
        int mid;
        if (end < start) {
            return -1;
        }
        mid = (start + end) / 2;
        if (key == arr[mid] && (mid == start || arr[mid - 1] != key)) {
            return mid;
        }
        if (key <= arr[mid])
        {
            return findFirstIndex(arr, start, mid - 1, key);
        } else {
            return findFirstIndex(arr, mid + 1, end, key);
        }
    }
    
    public static int findLastIndex(int[] arr, int start, int end, int key) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (key == arr[mid] && (mid == end || arr[mid + 1] != key)) {
            return mid;
        }
        if (key < arr[mid])
        {
            return findLastIndex(arr, start, mid - 1, key);
        } else {
            return findLastIndex(arr, mid + 1, end, key);
        }
    }
    
    public static int findKeyCount2(int[] arr, int size, int key) {
        int firstIndex, lastIndex;
        firstIndex = findFirstIndex(arr, 0, size - 1, key);
        lastIndex = findLastIndex(arr, 0, size - 1, key);
        return (lastIndex - firstIndex + 1);
    }
    
    public static void main27() {
        int[] first = { 1, 5, 10, 13, 20, 30, 8, 7, 6 };
        System.out.println(findKeyCount(first, first.length, 6));
        System.out.println(findKeyCount2(first, first.length, 6));
    }
    /*
    1
    1
    */
    
    /* Using binary search method. */
    public static int firstIndex(int arr[], int size, int low, int high, int value) {
        int mid = 0;
        if (high >= low)
            mid = (low + high) / 2;
    
        /*
         * Find first occurrence of value, either it should be the first element of the
         * array or the value before it is smaller than it.
         */
        if ((mid == 0 || arr[mid - 1] < value) && (arr[mid] == value))
            return mid;
        else if (arr[mid] < value)
            return firstIndex(arr, size, mid + 1, high, value);
        else
            return firstIndex(arr, size, low, mid - 1, value);
    }
    
    public static boolean isMajority2(int arr[], int size) {
        int majority = arr[size / 2];
        int i = firstIndex(arr, size, 0, size - 1, majority);
        /*
         * we are using majority element form array so we will get some valid index
         * always.
         */
        if (((i + size / 2) <= (size - 1)) && arr[i + size / 2] == majority)
            return true;
        else
            return false;
    }
    

    public static boolean isMajority(int arr[], int size) {
        int count = 0;
        int mid = arr[size/2];
        for(int i=0;i<size;i++)
            if(arr[i] == mid)
                count += 1;

        if(count > size/2)
            return true;
        return false;
    }

    public static void main28() {
        int[] arr = {3, 3, 3, 3, 4, 5, 10};
        System.out.println(isMajority(arr, arr.length));
        System.out.println(isMajority2(arr, arr.length));
    }
    /*
    true
    */
    public static int maxProfit(int stocks[], int size) {
        int maxProfit = 0;
        int buy = 0, sell = 0;

        for(int i =0;i< size-1;i++){
            for(int j=i+1;j<size ;j++){
                if(maxProfit <stocks[j]- stocks[i]){
                    maxProfit = stocks[j]- stocks[i];
                    buy = i;
                    sell = j;
                }
            }
        }
        System.out.println("Purchase day is " + buy + " at price " + stocks[buy]);
        System.out.println("Sell day is " + sell + " at price " + stocks[sell]);
        return maxProfit;
    }
    
    public static int maxProfit2(int stocks[], int size) {
        int buy = 0, sell = 0;
        int curMin = 0;
        int currProfit = 0;
        int maxProfit = 0;
        for (int i = 0; i < size; i++) {
            if (stocks[i] < stocks[curMin]) {
                curMin = i;
            }
            currProfit = stocks[i] - stocks[curMin];
            if (currProfit > maxProfit) {
                buy = curMin;
                sell = i;
                maxProfit = currProfit;
            }
        }
        System.out.println("Purchase day is " + buy + " at price " + stocks[buy]);
        System.out.println("Sell day is " + sell + " at price " + stocks[sell]);
        return maxProfit;
    }
    
    public static void main29() {
        int[] first = { 10, 150, 6, 67, 61, 16, 86, 6, 67, 78, 150, 3, 28, 143 };
        System.out.println(maxProfit(first, first.length));
        System.out.println(maxProfit2(first, first.length));

    }
    /*
    Purchase day is- 2 at price 6
    Sell day is- 10 at price 150
    144
    */
    
    public static int findMedian(int[] arrFirst, int sizeFirst, int[] arrSecond, int sizeSecond) {
        int medianIndex = ((sizeFirst + sizeSecond) + (sizeFirst + sizeSecond) % 2) / 2;// ceiling
                                                                                        // function.
        int i = 0, j = 0;
        int count = 0;
        while (count < medianIndex - 1) {
            if (i < sizeFirst - 1 && arrFirst[i] < arrSecond[j]) {
                i++;
            } else {
                j++;
            }
            count++;
        }
        if (arrFirst[i] < arrSecond[j]) {
            return arrFirst[i];
        } else {
            return arrSecond[j];
        }
    }
    
    public static void main30() {
        int[] first = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        int[] second = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        System.out.println(findMedian(first, first.length, second, second.length));
    }
    /*
    6
    */


    
    public static int search01(int[] arr, int size) {
        for(int i=0;i<size;i++)
            if(arr[i] == 1)
                return i;
        return -1;
    }
    
    public static int binarySearch01(int[] arr, int size) {
        if (size == 1 && arr[0] == 1) {
            return 0;
        }
        return binarySearch01Util(arr, 0, size - 1);
    }
    
    public static int binarySearch01Util(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (1 == arr[mid] && 0 == arr[mid - 1]) {
            return mid;
        }
        if (0 == arr[mid]) {
            return binarySearch01Util(arr, mid + 1, end);
        } else {
            return binarySearch01Util(arr, start, mid - 1);
        }
    }
    
    public static void main31() {
        int[] first = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(search01(first, first.length));
        System.out.println(binarySearch01(first, first.length));

    }
    /*
    8
    */

    public static int rotationMax(int[] arr, int size) {
        for(int i=0;i<size-1;i++)
            if(arr[i] > arr[i+1])
                return arr[i];
        return -1;
    }


    public static int rotationMaxUtil(int arr[], int start, int end) {
        if (end <= start) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1])
            return arr[mid];
    
        if (arr[start] <= arr[mid]) /* increasing part. */
            return rotationMaxUtil(arr, mid + 1, end);
        else
            return rotationMaxUtil(arr, start, mid - 1);
    }
    
    public static int rotationMax2(int[] arr, int size) {
        return rotationMaxUtil(arr, 0, size - 1);
    }
    
    public static void main32() {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 8, 10, 20, 30, 34 };
        System.out.println(rotationMax(first, first.length));
        System.out.println(rotationMax2(first, first.length));
    }
    /*
    77
    */   

    public static int findRotationMax(int[] arr, int size) {
        for(int i=0;i<size-1;i++)
            if(arr[i] > arr[i+1])
                return i;
        return -1;
    }


    public static int findRotationMaxUtil(int arr[], int start, int end) {
        /* single element case. */
        if (end <= start)
            return start;
    
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1])
            return mid;
    
        if (arr[start] <= arr[mid]) /* increasing part. */
            return findRotationMaxUtil(arr, mid + 1, end);
        else
            return findRotationMaxUtil(arr, start, mid - 1);
    }
    
    public static int findRotationMax2(int[] arr, int size) {
        return findRotationMaxUtil(arr, 0, size - 1);
    }
    
    public static void main33() {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 8, 10, 20, 30, 34 };
        System.out.println(findRotationMax(first, first.length));
        System.out.println(findRotationMax2(first, first.length));
    }
    /*
    2
    */
    
    public static int countRotation(int[] arr, int size) {
        int maxIndex = findRotationMaxUtil(arr, 0, size - 1);
        return (maxIndex + 1) % size;
    }
    public static void main34() {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 8, 10, 20, 30, 34 };
        System.out.println(countRotation(first, first.length));
    }
    /*
    3
    */
    
    public static int searchRotateArray(int[] arr, int size, int key) {
        for(int i=0;i<size-1;i++)
            if(arr[i] == key)
                return i;
        return -1;
    }

    public static int binarySearchRotateArrayUtil(int[] arr, int start, int end, int key) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (arr[mid] > arr[start]) {
            if (arr[start] <= key && key < arr[mid]) {
                return binarySearchRotateArrayUtil(arr, start, mid - 1, key);
            } else {
                return binarySearchRotateArrayUtil(arr, mid + 1, end, key);
            }
        } else {
            if (arr[mid] < key && key <= arr[end]) {
                return binarySearchRotateArrayUtil(arr, mid + 1, end, key);
            } else {
                return binarySearchRotateArrayUtil(arr, start, mid - 1, key);
            }
        }
    }
    
    public static int binarySearchRotateArray(int[] arr, int size, int key) {
        return binarySearchRotateArrayUtil(arr, 0, size - 1, key);
    }
    
    public static void main35() {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        System.out.println(searchRotateArray(first, first.length, 20));
        System.out.println(binarySearchRotateArray(first, first.length, 20));
        System.out.println(countRotation(first, first.length));
        System.out.println(first[findRotationMax(first, first.length)]);
    }
    /*
    15
    3
    77
    */
    
    public static int minAbsDiffAdjCircular(int[] arr, int size) {
        int diff = 9999999;
        if (size < 2)
            return -1;
    
        for (int i = 0; i < size; i++)
            diff = Math.min(diff, Math.abs(arr[i] - arr[(i + 1) % size]));
    
        return diff;
    }
    
    // Testing Code
    public static void main36() {
        int[] arr = { 5, 29, 18, 51, 11 };
        System.out.println(minAbsDiffAdjCircular(arr, arr.length));
    }
    /*
    6
    */
    
    public static void swapch(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
    public static void transformArrayAB1(char[] arr, int size) {
        int N = size / 2, i, j;
        for (i = 1; i < N; i++) {
            for (j = 0; j < i; j++) {
                swapch(arr, N - i + 2 * j, N - i + 2 * j + 1);
            }
        }
    }
    
    public static void main37() {
        char[] str = "aaaabbbb".toCharArray();
        transformArrayAB1(str, str.length);
        System.out.println(str);
    }
    /*
    abababab
    */
    
    public static boolean checkPermutation(char[] array1, int size1, char[] array2, int size2) {
        if (size1 != size2) {
            return false;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < size1; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermutation2(char[] arr1, int size1, char[] arr2, int size2) {
        if (size1 != size2) 
            return false;

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < size1; i++) {
            if (hm.containsKey(arr1[i])) {
                hm.put(arr1[i],  hm.get(arr1[i]) + 1);
            } else
                hm.put(arr1[i], 1);
        }
        for (int i = 0; i < size2; i++) {
            if (hm.containsKey(arr2[i]) && hm.get(arr2[i]) != 0) {
                hm.put(arr2[i],  hm.get(arr2[i]) - 1);
            } else
                return false;
        }
        return true;
    }


    public static boolean checkPermutation3(char[] array1, int size1, char[] array2, int size2) {
        if (size1 != size2) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < size1; i++) {
            count[ array1[i] ]++;
            count[ array2[i] ]--;
        }

        for (int i = 0; i < size1; i++) {
            if (count[i] != 0) {
                System.out.println("Not Permutation");
                return false;
            }
        }
        System.out.println("Permutation.");
        return true;
    }
    
    public static void main38() {
        char[] str1 = "aaaabbbb".toCharArray();
        char[] str2 = "bbaaaabb".toCharArray();
        System.out.println(checkPermutation(str1, str1.length, str2, str2.length));
    }
    /*
    true
    */
    
    public static boolean findElementIn2DArray(int[] arr[], int r, int c, int value) {
        int row = 0;
        int column = c - 1;
        while (row < r && column >= 0) {
            if (arr[row][column] == value) {
                return true;
            } else if (arr[row][column] > value) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
    
    public static boolean isAP(int[] arr, int size) {
        if (size <= 1)
            return true;
    
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < size; i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }
    
    public static boolean isAP2(int[] arr, int size) {
        int first = 9999999;
        int second = 9999999;
        int value;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second)
                second = arr[i];
        }
        int diff = second - first;
    
        for (int i = 0; i < size; i++) {
            if (hs.contains(arr[i]))
                return false;
            hs.add(arr[i]);
        }
        for (int i = 0; i < size; i++) {
            value = first + i * diff;
            if (!hs.contains(value))
                return false;
        }
        return true;
    }
    
    public static boolean isAP3(int[] arr, int size) {
        int first = 9999999;
        int second = 9999999;
        int[] count = new int[size];
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second)
                second = arr[i];
        }
        int diff = second - first;
    
        for (int i = 0; i < size; i++)
        {
            index = (arr[i] - first) / diff;
            if (index > size - 1 || count[index] != 0)
                return false;
            count[index] = 1;
        }    
    
        for (int i = 0; i < size; i++)
        {       
            if (count[i] != 1)
                return false;
        }
        return true;
    }
    
    public static void main39() {
        int[] arr = { 20, 25, 15, 5, 0, 10, 35, 30};
        System.out.println(isAP(arr, arr.length));
        System.out.println(isAP2(arr, arr.length));
        System.out.println(isAP3(arr, arr.length));
    
    }
    /*
    true
    true
    true
    */
    
    public static int findBalancedPoint(int[] arr, int size) {
        int first = 0;
        int second = 0;
        for (int i = 1; i < size; i++)
            second += arr[i];
    
        for (int i = 0; i < size; i++) {
            if (first == second) {
                System.out.println(i);
                return i;
            }
            if (i < size - 1)
                first += arr[i];
            second -= arr[i + 1];
        }
        return -1;
    }
    
    // Testing Code
    public static void main40() {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(findBalancedPoint(arr, arr.length));
    
    }
    /*
    3
    */
    
    public static int findFloor(int arr[], int size, int value) {
        int start = 0;
        int stop = size - 1;
        int mid;
        while (start <= stop) {
            mid = (start + stop) / 2;
            /*
             * search value is equal to arr[mid] value.. search value is greater than mid
             * index value and less than mid+1 index value. value is greater than
             * arr[size-1] then floor is arr[size-1]
             */
            if (arr[mid] == value || (arr[mid] < value && (mid == size - 1 || arr[mid + 1] > value)))
                return arr[mid];
            else if (arr[mid] < value)
                start = mid + 1;
            else
                stop = mid - 1;
        }
        return -1;
    }
    
    public static int findCeil(int arr[], int size, int value) {
        int start = 0;
        int stop = size - 1;
        int mid;
    
        while (start <= stop) {
            mid = (start + stop) / 2;
            /*
             * search value is equal to arr[mid] value.. search value is less than mid index
             * value and greater than mid-1 index value. value is less than arr[0] then ceil
             * is arr[0]
             */
            if (arr[mid] == value || (arr[mid] > value && (mid == 0 || arr[mid - 1] < value)))
                return arr[mid];
            else if (arr[mid] < value)
                start = mid + 1;
            else
                stop = mid - 1;
        }
        return -1;
    }
    
    public static void main41() {
        int[] arr = {2, 4, 8, 16};
        System.out.println(findFloor(arr, arr.length, 5));
        System.out.println(findCeil(arr, arr.length, 5));
    }
    /*
    1
    2
    */
    
    public static int closestNumber(int arr[], int size, int num) {
        int start = 0;
        int stop = size - 1;
        int output = -1;
        int minDist = Integer.MAX_VALUE;
        int mid;
    
        while (start <= stop) {
            mid = (start + stop) / 2;
            if (minDist > Math.abs(arr[mid] - num)) {
                minDist = Math.abs(arr[mid] - num);
                output = arr[mid];
            }
            if (arr[mid] == num)
                break;
            else if (arr[mid] > num)
                stop = mid - 1;
            else
                start = mid + 1;
        }
        return output;
    }
    
    public static void main42() {
        int[] arr = {2, 4, 8, 16};
        System.out.println(closestNumber(arr, arr.length, 9));
    }
    /*
    8
    */
    
    public static boolean duplicateKDistance(int arr[], int size, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
        for (int i = 0; i < size; i++) {
            if (hm.containsKey(arr[i]) && i - hm.get(arr[i]) <= k) {
                System.out.println("Value:" + arr[i] + " Index: " + hm.get(arr[i]) + " & " + i);
                return true;
            } else
                hm.put(arr[i], i);
        }
        return false;
    }
    
    // Testing Code
    public static void main43() {
        int[] arr = { 1, 2, 3, 1, 4, 5 };
        duplicateKDistance(arr, arr.length, 3);
    }
    /*
    Value:1 Index: 0 & 3
    */
    public static void frequencyCounts(int[] arr, int size) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        for(Integer key : hm.keySet())
            System.out.print("(" + key + " : " + hm.get(key)+") ");
        System.out.println();
    }

    public static void frequencyCounts2(int[] arr, int size) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < size; i++) {
            if(arr[i] == arr[i-1])
                count++;
            else{
                System.out.print("(" + arr[i-1] + " : " + count+ ") ");
                count = 1;
            }
        }
        System.out.print("(" + arr[size-1] + " : " + count + ") ");
        System.out.println();
    }

    public static void frequencyCounts3(int[] arr, int size) {
        int[] aux = new int[size+1];
        for (int i = 0; i < size; i++) {
            aux[arr[i]] += 1;
        }
        for (int i = 0; i < size+1; i++) {
            if(aux[i] > 0){
                System.out.print("(" +  i + " : " + aux[i] +") ");
            }
        }
        System.out.println();
    }

    public static void frequencyCounts4(int[] arr, int size) {
        int index;
        for (int i = 0; i < size; i++) {
            while (arr[i] > 0) {
                index = arr[i] - 1;
                if (arr[index] > 0) {
                    arr[i] = arr[index];
                    arr[index] = -1;
                } else {
                    arr[index] -= 1;
                    arr[i] = 0;
                }
            }
        }
        for (int i = 0; i < size; i++)
            if(arr[i] != 0)
                System.out.print("(" + (i + 1) + " : " + Math.abs(arr[i])+") ");
        System.out.println();
    }
    
    public static void main44() {
        int[] arr = {1, 2, 2, 2, 1};
        frequencyCounts(arr, arr.length);
        frequencyCounts2(arr, arr.length);
        frequencyCounts3(arr, arr.length);
        frequencyCounts4(arr, arr.length);
    }
/*
(1 : 2) (2 : 3) 
(1 : 2) (2 : 3) 
(1 : 2) (2 : 3) 
(1 : 2) (2 : 3)    
*/
    
    public static void kLargestElements(int arrIn[], int size, int k) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = arrIn[i];
    
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            if (arrIn[i] >= arr[size - k]) {
                System.out.print(arrIn[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static void quickSelectUtil(int arr[], int lower, int upper, int k) {
        if (upper <= lower)
            return;
    
        int pivot = arr[lower];
        int start = lower;
        int stop = upper;
    
        while (lower < upper) {
            while (arr[lower] <= pivot  && lower < upper) {
                lower++;
            }
            while (arr[upper] > pivot && lower <= upper) {
                upper--;
            }
            if (lower < upper) {
                swap(arr, upper, lower);
            }
        }
    
        swap(arr, upper, start); // upper is the pivot position
        if (k < upper)
            quickSelectUtil(arr, start, upper - 1, k); // pivot -1 is the upper for left sub array.
        if (k > upper)
            quickSelectUtil(arr, upper + 1, stop, k); // pivot + 1 is the lower for right sub array.
    }
    
    public static void kLargestElements2(int arrIn[], int size, int k) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = arrIn[i];
    
        quickSelectUtil(arr, 0, size - 1, size - k);
        for (int i = 0; i < size; i++) {
            if (arrIn[i] >= arr[size - k]) {
                System.out.print(arrIn[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static void main45() {
        int[] arr = {10, 50, 30, 60, 15};
        kLargestElements(arr, arr.length, 2);
        kLargestElements2(arr, arr.length, 2);
    }
    
    /*
    50 60 
    50 60 
    */
    
    /*
    def ksmallest_elements(arrIn, k):
        size = len(arrIn)
        arr = list(arrIn)
        arr.sort()
        for i in range(size):
            if arrIn[i] <= arr[k-1]:
                print(arrIn[i], end=' ')
    
    def ksmallest_elements2(arrIn, k):
        size = len(arrIn)
        arr = list(arrIn)
        quick_select_util(arr, 0, size-1, k)
        for i in range(size):
            if arrIn[i] <= arr[k-1]:
                print(arrIn[i], end=' ')
    
    def main38():
        arr = [4, 2, 6, 1, 5]
        ksmallest_elements(arr, 3)
        print("")
        ksmallest_elements2(arr, 3)
        print("")
        arr = [ 1, 5, 8, 9, 6, 7, 3, 4, 2, 0]
        ksmallest_elements(arr, 5)
        print("")
        ksmallest_elements2(arr, 5)
        print("")
    
    */
    
    /* linear search method */
    public static int fixPoint(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == i)
                return i;
        } /* fix point not found so return invalid index */
        return -1;
    }
    
    /* Binary search method */
    public static int fixPoint2(int[] arr, int size) {
        int low = 0;
        int high = size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == mid)
                return mid;
            else if (arr[mid] < mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        /* fix point not found so return invalid index */
        return -1;
    }
    
    public static void main46() {
        int[] arr = {-10, -2, 0, 3, 11, 12, 35, 51, 200};
        System.out.println(fixPoint(arr, arr.length));
        System.out.println(fixPoint2(arr, arr.length));
    }
    /*
    3
    3
    */
    
    public static void subArraySums(int arr[], int size, int value) {
        int start=0, end=0, sum=0;
        while (start < size && end < size) {
            if (sum < value) {
                sum += arr[end];
                end += 1;    
            } else {
                sum -= arr[start];
                start += 1;
            }
            
            if (sum == value){
                System.out.println(start + " " + (end-1));
            } 
        }
    }
    
    public static void main47() {
        int[] arr = {15, 5, 5, 20, 10, 5, 5, 20, 10, 10};
        subArraySums(arr, arr.length, 20);
    }
    /*
    0 1
    3 3
    4 6
    7 7
    8 9
    */
    
    public static int maxConSub(int[] arr, int size) {
        int currMax = 0, maximum = 0;
        for (int i = 0; i < size; i++) {
            currMax += arr[i];
            if (currMax < 0)
                currMax = 0;
            if (maximum < currMax)
                maximum = currMax;
        }
        System.out.println(maximum);
        return maximum;
    }
    
    public static int maxConSubArr(int[] A, int sizeA, int[] B, int sizeB) {
        int currMax = 0;
        int maximum = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
    
        for (int i = 0; i < sizeB; i++)
            hs.add(B[i]);
    
        for (int i = 0; i < sizeA; i++)
            if (hs.contains(A[i]))
                currMax = 0;
            else
            {    
                currMax = currMax + A[i];
                if (currMax < 0)
                    currMax = 0;
                if (maximum < currMax)
                    maximum = currMax;
            }
        System.out.println(maximum);
        return maximum;
    }
    
    public static int maxConSubArr2(int A[], int sizeA, int B[], int sizeB) {
        Arrays.sort(B);
        int currMax = 0;
        int maximum = 0;
    
        for (int i = 0; i < sizeA; i++) {
            if (binarySearch(B, sizeB, A[i]))
                currMax = 0;
            else {
                currMax = currMax + A[i];
                if (currMax < 0)
                    currMax = 0;
                if (maximum < currMax)
                    maximum = currMax;
            }
        }
        System.out.println(maximum);
        return maximum;
    }
    
    public static void main48() {
        int[] arr = {1, 2, -3, 4, 5, -10, 6, 7};
        maxConSub(arr, arr.length);
        int[] arr2 = {1, 2, 3, 4, 5, -10, 6, 7, 3};
        int[] arr3 = {1, 3};
        maxConSubArr(arr2, arr2.length, arr3, arr3.length);
        maxConSubArr2(arr2, arr2.length, arr3, arr3.length);
    }
    /*
    13
    13
    13
    */
    
    public static int rainWater(int[] arr, int size) {
        int[] leftHigh = new int[size];
        int[] rightHigh = new int[size];
    
        int max = arr[0];
        leftHigh[0] = arr[0];
        for (int i = 1; i < size; i++) {
            if (max < arr[i])
                max = arr[i];
            leftHigh[i] = max;
        }
        max = arr[size - 1];
        rightHigh[size - 1] = arr[size - 1];
        for (int i = (size - 2); i >= 0; i--) {
            if (max < arr[i])
                max = arr[i];
            rightHigh[i] = max;
        }
    
        int water = 0;
        for (int i = 0; i < size; i++)
            water += Math.min(leftHigh[i], rightHigh[i]) - arr[i];
        System.out.println("Water : " + water);
        return water;
    }
    
    public static int rainWater2(int[] arr, int size) {
        int water = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0;
        int right = size - 1;
    
        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax)
                    leftMax = arr[left];
                else
                    water += leftMax - arr[left];
                left += 1;
            } else {
                if (arr[right] > rightMax)
                    rightMax = arr[right];
                else
                    water += rightMax - arr[right];
                right -= 1;
            }
        }
        System.out.println("Water : " + water);
        return water;
    }
    
    public static void main49() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        rainWater(arr, arr.length);
        rainWater2(arr, arr.length);
    }
    /*
    Water : 6
    Water : 6
    */
    
    public static void separateEvenAndOdd(int[] arr, int size) {
        int left = 0, right = size - 1;
        while (left < right) {
            if (arr[left] % 2 == 0) {
                left++;
            } else if (arr[right] % 2 == 1) {
                right--;
            } else {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }
    
    public static void main50() {
        int[] first = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        separateEvenAndOdd(first, first.length);
        for (int val : first) {
            System.out.print(val + " ");
        }
    }
    
    /*
    30 20 6 6 6 6 6 6 10 8 7 13 5 1
    */

    public static void main(String[] args) {
        main1();
        //main2();
        //main3();
        //main4();
        //main5();
        //main6();
        //main7();
        //main8();
        //main9();
        //main10A();
        //main11();
        //main12();
        //main13();
        //main14();
        //main15();
        //main16();
        //main17();
        //main18();
        //main19();
        /*main20();
        main21();
        main22();
        main23();
        main24();
        main25();
        main26();
        main27();
        main28();
        main29();
        main30();
        main31();
        main32();
        main33();
        main34();
        main35();
        main36();
        main37();
        main38();
        main39();
        main40();
        main41();
        main42();
        main43();
        main44();
        main45();
        main46();
        main47();
        main48();
        main49();
        main50();
        */
    }
}