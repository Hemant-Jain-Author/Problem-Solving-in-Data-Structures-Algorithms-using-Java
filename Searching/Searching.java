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
    public static boolean Binarysearch(int[] arr, int size, int value) {
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

    public static boolean BinarySearchRec(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;
        return BinarySearchRecUtil(arr, low, high, value);
    }

    // Binary Search Algorithm - Recursive Way
    public static boolean BinarySearchRecUtil(int[] arr, int low, int high, int value) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == value) {
            return true;
        } else if (arr[mid] < value) {
            return BinarySearchRecUtil(arr, mid + 1, high, value);
        } else {
            return BinarySearchRecUtil(arr, low, mid - 1, value);
        }
    }

    public static int BinarySearch(int[] arr, int start, int end, int key, boolean isInc) {
        int mid;
        if (end < start) {
            return -1;
        }
        mid = (start + end) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (isInc != false && key < arr[mid] || isInc == false && key > arr[mid]) {
            return BinarySearch(arr, start, mid - 1, key, isInc);
        } else {
            return BinarySearch(arr, mid + 1, end, key, isInc);
        }
    }

    public static void main1(String[] args) {
        int[] first = { 1, 3, 5, 7, 9, 25, 30 };
        System.out.println(linearSearchUnsorted(first, 7, 8));
        System.out.println(linearSearchSorted(first, 7, 8));
        System.out.println(Binarysearch(first, 7, 8));
        System.out.println(BinarySearchRec(first, 7, 8));
        System.out.println(linearSearchUnsorted(first, 7, 25));
        System.out.println(linearSearchSorted(first, 7, 25));
        System.out.println(Binarysearch(first, 7, 25));
        System.out.println(BinarySearchRec(first, 7, 25));

    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int FirstRepeated(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return 0;
    }

    public static void main2(String[] args) {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 34, 20, 30 };
        System.out.println(FirstRepeated(first, first.length));
    }

    public static void printRepeating(int[] arr, int size) {
        System.out.print(" \nRepeating elements are ");
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(" " + arr[i]);
                }
            }
        }
    }

    public static void printRepeating2(int[] arr, int size) {
        Arrays.sort(arr);
        System.out.print(" \nRepeating elements are ");

        for (int i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1]) {
                System.out.print(" " + arr[i]);
            }
        }
    }

    public static void printRepeating3(int[] arr, int size) {
        HashSet<Integer> hs = new HashSet<Integer>();
        System.out.print(" \nRepeating elements are ");
        for (int i = 0; i < size; i++) {
            if (hs.contains(arr[i])) {
                System.out.print(" " + arr[i]);
            } else {
                hs.add(arr[i]);
            }
        }
    }

    public static void printRepeating4(int[] arr, int size, int range) {
        int[] count = new int[range];
        int i;
        for (i = 0; i < size; i++) {
            count[i] = 0;
        }
        System.out.print(" \nRepeating elements are ");
        for (i = 0; i < size; i++) {
            if (count[arr[i]] == 1) {
                System.out.print(" " + arr[i]);
            } else {
                count[arr[i]]++;
            }
        }
    }

    public static void main3(String[] args) {
        int[] first = { 1, 3, 5, 3, 9, 1, 30 };
        printRepeating(first, first.length);
        printRepeating2(first, first.length);
        printRepeating3(first, first.length);
        printRepeating4(first, first.length, 50);
    }

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

    public static void main4(String[] args) {
        int[] first = { 1, 3, 5, 3, 9, 1, 30 };
        int[] ret = removeDuplicates(first, first.length);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }

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

    public static int findMissingNumber2(int[] arr, int size, int range) {
        int i;
        int xorSum = 0;
        // get the XOR of all the numbers from 1 to range
        for (i = 1; i <= range; i++) {
            xorSum ^= i;
        }
        // loop through the array and get the XOR of elements
        for (i = 0; i < size; i++) {
            xorSum ^= arr[i];
        }
        return xorSum;
    }

    public static int findMissingNumber3(int[] arr, int size, int upperRange) {
        HashSet<Integer> st = new HashSet<Integer>();

        int i = 0;
        while (i < size) {
            st.add(arr[i]);
            i += 1;
        }
        i = 1;
        while (i <= upperRange) {
            if (st.contains(i) == false)
                return i;
            i += 1;
        }
        System.out.println("NoNumberMissing");
        return -1;
    }

    public static void main5(String[] args) {
        int[] first = { 1, 3, 5, 4, 6, 8, 7 };
        System.out.println(findMissingNumber(first, first.length));
        System.out.println(findMissingNumber2(first, first.length, 8));
        System.out.println(findMissingNumber3(first, first.length, 8));
    }

    public static void MissingValues(int[] arr, int size) {
        Arrays.sort(arr);
        int value = arr[0];
        int i = 0;
        while (i < size) {
            if (value == arr[i]) {
                value += 1;
                i += 1;
            } else {
                System.out.println(value);
                value += 1;
            }
        }
    }

    public static void MissingValues2(int[] arr, int size) {
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
                System.out.println(i);
            }
        }
    }

    public static void main6(String[] args) {
        int[] arr = { 1, 9, 2, 8, 3, 7, 4, 6 };
        int size = arr.length;
        MissingValues(arr, size);
        MissingValues2(arr, size);
    }

    public static void OddCount(int[] arr, int size) {
        HashMap<Integer, Integer> ctr = new HashMap<Integer, Integer>();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (ctr.containsKey(arr[i]))
                ctr.put(arr[i], ctr.get(arr[i]) + 1);
            else
                ctr.put(arr[i], 1);
        }
        for (int i = 0; i < size; i++) {
            if (ctr.containsKey(arr[i]) && (ctr.get(arr[i]) % 2 == 1)) {
                System.out.println(arr[i]);
                count++;
                ctr.remove(arr[i]);
            }
        }
        System.out.println("Odd count is :: " + count);
    }

    public static void OddCount2(int[] arr, int size) {
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
        System.out.println(first + second);
    }

    public static void SumDistinct(int[] arr, int size) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < (size - 1); i++) {
            if (arr[i] != arr[i + 1])
                sum += arr[i];
        }
        sum += arr[size - 1];
        System.out.println(sum);
    }

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
        System.out.println(" Minimum sum elements are : " + arr[minFirst] + " , " + arr[minSecond]);
    }

    public static void minAbsSumPair2(int[] arr, int size) {
        int l, r, minSum, sum, minFirst, minSecond;
        // Array should have at least two elements
        if (size < 2) {
            System.out.println("Invalid Input");
            return;
        }
        Arrays.sort(arr);// Arrays.sort(arr);

        // Initialization of values
        minFirst = 0;
        minSecond = size - 1;
        minSum = Math.abs(arr[minFirst] + arr[minSecond]);
        for (l = 0, r = size - 1; l < r;) {
            sum = (arr[l] + arr[r]);
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);/// just corrected......hemant
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
        System.out.println(" Minimum sum pair : " + arr[minFirst] + " , " + arr[minSecond]);
    }

    public static void main7(String[] str) {
        int[] first = { 1, 5, -10, 3, 2, -6, 8, 9, 6 };
        minAbsSumPair2(first, first.length);
        minAbsSumPair(first, first.length);

    }

    public static boolean FindPair(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((arr[i] + arr[j]) == value) {
                    System.out.println("The pair is : " + arr[i] + "," + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean FindPair2(int[] arr, int size, int value) {
        int first = 0, second = size - 1;
        int curr;
        Arrays.sort(arr);// Arrays.sort(arr);
        while (first < second) {
            curr = arr[first] + arr[second];
            if (curr == value) {
                System.out.println("The pair is " + arr[first] + "," + arr[second]);
                return true;
            } else if (curr < value) {
                first++;
            } else {
                second--;
            }
        }
        return false;
    }

    public static boolean FindPair3(int[] arr, int size, int value) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            if (hs.contains(value - arr[i])) {
                System.out.println("The pair is : " + arr[i] + " , " + (value - arr[i]));
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }

    public static void main8(String[] args) {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        System.out.println(FindPair(first, first.length, 8));
        System.out.println(FindPair2(first, first.length, 8));
        System.out.println(FindPair3(first, first.length, 8));

    }

    public static boolean FindDifference(int arr[], int size, int value) {
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

    public static boolean FindDifference2(int arr[], int size, int value) {
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

    public static int findMinDiff(int[] arr, int size) {
        Arrays.sort(arr);
        int diff = 9999999;

        for (int i = 0; i < (size - 1); i++) {
            if ((arr[i + 1] - arr[i]) < diff)
                diff = arr[i + 1] - arr[i];
        }
        return diff;
    }

    public static int MinDiffPair(int arr1[], int size1, int arr2[], int size2) {
        int minDiff = 9999999;
        int first = 0;
        int second = 0;
        int out1 = 0, out2 = 0, diff;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (first < size1 && second < size2) {
            diff = Math.abs(arr1[first] - arr2[second]);
            if (minDiff > diff) {
                minDiff = diff;
                out1 = arr1[first];
                out2 = arr2[second];
            }
            if (arr1[first] < arr2[second])
                first += 1;
            else
                second += 1;
        }
        System.out.println("The pair is :: " + out1 + out2);
        System.out.println("Minimum difference is :: " + minDiff);
        return minDiff;
    }

    public static void main88(String[] args) {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        System.out.println(FindDifference(first, first.length, 6));
        System.out.println(FindDifference2(first, first.length, 6));
        System.out.println(findMinDiff(first, first.length));
        System.out.println(MinDiffPair(first, first.length, first, first.length));
    }

    public static void ClosestPair(int arr[], int size, int value) {
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
        System.out.println("closest pair is ::" + first + second);
    }

    public static void ClosestPair2(int arr[], int size, int value) {
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
        System.out.println("closest pair is :: " + first + second);
    }

    public static void main99(String[] args) {
        int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };
        ClosestPair(first, first.length, 6);
        ClosestPair2(first, first.length, 6);
    }

    public static boolean SumPairRestArray(int[] arr, int size) {
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
                System.out.println("Pair is :: " + arr[low] + arr[high]);
                return true;
            } else if (curr < value)
                low += 1;
            else
                high -= 1;
        }
        return false;
    }

    public static void ZeroSumTriplets(int[] arr, int size) {
        for (int i = 0; i < (size - 2); i++) {
            for (int j = i + 1; j < (size - 1); j++) {
                for (int k = j + 1; k < size; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0)
                        System.out.println("Triplet :: " + arr[i] + arr[j] + arr[k]);
                }
            }
        }
    }

    public static void ZeroSumTriplets2(int[] arr, int size) {
        int start, stop;
        Arrays.sort(arr);
        for (int i = 0; i < (size - 2); i++) {
            start = i + 1;
            stop = size - 1;

            while (start < stop) {
                if (arr[i] + arr[start] + arr[stop] == 0) {
                    System.out.println("Triplet :: " + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if (arr[i] + arr[start] + arr[stop] > 0)
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }

    public static void findTriplet(int arr[], int size, int value) {
        for (int i = 0; i < (size - 2); i++)
            for (int j = i + 1; j < (size - 1); j++)
                for (int k = j + 1; k < size; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == value)
                        System.out.println("Triplet :: " + arr[i] + arr[j] + arr[k]);
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
                    System.out.println("Triplet ::" + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if (arr[i] + arr[start] + arr[stop] > value)
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }

    public static void ABCTriplet(int[] arr, int size) {
        int start, stop;
        Arrays.sort(arr);
        for (int i = 0; i < (size - 2); i++) {
            start = i + 1;
            stop = size - 1;
            while (start < stop) {
                if (arr[i] == arr[start] + arr[stop]) {
                    System.out.println("Triplet ::%d, %d, %d" + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if (arr[i] > arr[start] + arr[stop])
                    stop -= 1;
                else
                    start += 1;
            }
        }
    }

    public static void SmallerThenTripletCount(int arr[], int size, int value) {
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
        System.out.println(count);
    }

    public static void APTriplets(int[] arr, int size) {
        int i, j, k;
        for (i = 1; i < size - 1; i++) {
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < size) {
                if (arr[j] + arr[k] == 2 * arr[i]) {
                    System.out.println("Triplet ::" + arr[j] + arr[i] + arr[k]);
                    k += 1;
                    j -= 1;
                } else if (arr[j] + arr[k] < 2 * arr[i])
                    k += 1;
                else
                    j -= 1;
            }
        }
    }

    public static void GPTriplets(int[] arr, int size) {
        int i, j, k;
        for (i = 1; i < size - 1; i++) {
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < size) {
                if (arr[j] * arr[k] == arr[i] * arr[i]) {
                    System.out.println("Triplet is :: " + arr[j] + arr[i] + arr[k]);
                    k += 1;
                    j -= 1;
                } else if (arr[j] + arr[k] < 2 * arr[i])
                    k += 1;
                else
                    j -= 1;
            }
        }
    }

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

    public static void main9(String[] args) {
        int[] first = { 1, 30, 5, 13, 9, 31, 5 };
        System.out.println(getMax(first, first.length));
        System.out.println(getMax2(first, first.length));
        System.out.println(getMax3(first, first.length, 50));
    }

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
        Arrays.sort(arr); // Sort(arr,size);
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

    public static void main10(String[] args) {
        int[] first = { 1, 5, 5, 13, 5, 31, 5 };
        System.out.println(getMajority(first, first.length));
        System.out.println(getMajority2(first, first.length));
        System.out.println(getMajority3(first, first.length));
    }

    public static int getMedian(int[] arr, int size) {
        Arrays.sort(arr);
        return arr[size / 2];
    }

    public static int SearchBotinicArrayMax(int[] arr, int size) {
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
            System.out.println("error");
            return 0;
        }
        return arr[mid];
    }

    public static int SearchBitonicArray(int[] arr, int size, int key) {
        int max = FindMaxBitonicArray(arr, size);
        int k = BinarySearch(arr, 0, max, key, true);
        if (k != -1) {
            return k;
        } else {
            return BinarySearch(arr, max + 1, size - 1, key, false);
        }
    }

    public static int FindMaxBitonicArray(int[] arr, int size) {
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

    public static void main11(String[] args) {
        int[] first = { 1, 5, 10, 13, 20, 30, 8, 7, 6 };

        System.out.println(SearchBotinicArrayMax(first, first.length));
        System.out.println(SearchBitonicArray(first, first.length, 7));
    }

    public static int findKeyCount(int[] arr, int size, int key) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                count++;
            }
        }
        return count;
    }

    public static int findKeyCount2(int[] arr, int size, int key) {
        int firstIndex, lastIndex;
        firstIndex = findFirstIndex(arr, 0, size - 1, key);
        lastIndex = findLastIndex(arr, 0, size - 1, key);
        return (lastIndex - firstIndex + 1);
    }

    /* Using binary search method. */
    public static int FirstIndex(int arr[], int size, int low, int high, int value) {
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
            return FirstIndex(arr, size, mid + 1, high, value);
        else
            return FirstIndex(arr, size, low, mid - 1, value);
    }

    public static boolean isMajority(int arr[], int size) {
        int majority = arr[size / 2];
        int i = FirstIndex(arr, size, 0, size - 1, majority);
        /*
         * we are using majority element form array so we will get some valid index
         * always.
         */
        if (((i + size / 2) <= (size - 1)) && arr[i + size / 2] == majority)
            return true;
        else
            return false;
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
        if (key <= arr[mid])// <= is us the number.t in sorted array.
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
        if (key < arr[mid])// <
        {
            return findLastIndex(arr, start, mid - 1, key);
        } else {
            return findLastIndex(arr, mid + 1, end, key);
        }
    }

    public static void main12(String[] args) {
        int[] first = { 1, 5, 10, 13, 20, 30, 8, 7, 6 };
        System.out.println(findKeyCount(first, first.length, 6));
        System.out.println(findKeyCount2(first, first.length, 6));
    }

    public static int maxProfit(int stocks[], int size) {
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
        System.out.println("Purchase day is- " + buy + " at price " + stocks[buy]);
        System.out.println("Sell day is- " + sell + " at price " + stocks[sell]);
        return maxProfit;
    }

    public static void main133(String[] args) {
        int[] first = { 10, 150, 6, 67, 61, 16, 86, 6, 67, 78, 150, 3, 28, 143 };
        System.out.println(maxProfit(first, first.length));
    }

    public static int findMedian(int[] arrFirst, int sizeFirst, int[] arrSecond, int sizeSecond) {
        int medianIndex = ((sizeFirst + sizeSecond) + (sizeFirst + sizeSecond) % 2) / 2;// cealing
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

    public static void main13(String[] args) {
        int[] first = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        int[] second = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        System.out.println(findMedian(first, first.length, second, second.length));
    }

    public static int BinarySearch01(int[] arr, int size) {
        if (size == 1 && arr[0] == 1) {
            return 0;
        }
        return BinarySearch01Util(arr, 0, size - 1);
    }

    public static int BinarySearch01Util(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (1 == arr[mid] && 0 == arr[mid - 1]) {
            return mid;
        }
        if (0 == arr[mid]) {
            return BinarySearch01Util(arr, mid + 1, end);
        } else {
            return BinarySearch01Util(arr, start, mid - 1);
        }
    }

    public static void main14(String[] args) {
        int[] first = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(BinarySearch01(first, first.length));
    }

    public static int RotationMaxUtil(int arr[], int start, int end) {
        if (end <= start) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1])
            return arr[mid];

        if (arr[start] <= arr[mid]) /* increasing part. */
            return RotationMaxUtil(arr, mid + 1, end);
        else
            return RotationMaxUtil(arr, start, mid - 1);
    }

    public static int RotationMax(int[] arr, int size) {
        return RotationMaxUtil(arr, 0, size - 1);
    }

    public static int FindRotationMaxUtil(int arr[], int start, int end) {
        /* single element case. */
        if (end <= start)
            return start;

        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1])
            return mid;

        if (arr[start] <= arr[mid]) /* increasing part. */
            return FindRotationMaxUtil(arr, mid + 1, end);
        else
            return FindRotationMaxUtil(arr, start, mid - 1);
    }

    public static int FindRotationMax(int[] arr, int size) {
        return FindRotationMaxUtil(arr, 0, size - 1);
    }

    public static int CountRotation(int[] arr, int size) {
        int maxIndex = FindRotationMaxUtil(arr, 0, size - 1);
        return (maxIndex + 1) % size;
    }

    public static int BinarySearchRotateArrayUtil(int[] arr, int start, int end, int key) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (arr[mid] > arr[start]) {
            if (arr[start] <= key && key < arr[mid]) {
                return BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            } else {
                return BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            }
        } else {
            if (arr[mid] < key && key <= arr[end]) {
                return BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            } else {
                return BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            }
        }
    }

    public static int BinarySearchRotateArray(int[] arr, int size, int key) {
        return BinarySearchRotateArrayUtil(arr, 0, size - 1, key);
    }

    public static void main555(String[] args) {
        int[] first = { 34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        System.out.println(BinarySearchRotateArray(first, first.length, 20));
        System.out.println(CountRotation(first, first.length));
        System.out.println(first[FindRotationMax(first, first.length)]);
    }

    public static int minAbsDiffAdjCircular(int[] arr, int size) {
        int diff = 9999999;
        if (size < 2)
            return -1;

        for (int i = 0; i < size; i++)
            diff = Math.min(diff, Math.abs(arr[i] - arr[(i + 1) % size]));

        return diff;
    }

    /*
     * Testing code
     */
    public static void main666(String[] str) {
        int[] arr = { 5, 29, 18, 51, 11 };
        System.out.println(minAbsDiffAdjCircular(arr, arr.length));
    }

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

    public static void main16(String[] args) {
        char[] str = "aaaabbbb".toCharArray();
        transformArrayAB1(str, str.length);
        System.out.println(str);
    }

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

    public static void main17(String[] args) {
        char[] str1 = "aaaabbbb".toCharArray();
        char[] str2 = "bbaaaabb".toCharArray();

        System.out.println(checkPermutation(str1, str1.length, str2, str2.length));
    }

    public static boolean FindElementIn2DArray(int[] arr[], int r, int c, int value) {
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
            index = (arr[i] - first) / diff;
        if (index > size - 1 || count[index] != 0)
            return false;
        count[index] = 1;

        for (int i = 0; i < size; i++)
            if (count[i] != 1)
                return false;
        return true;
    }

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

    /*
     * Testing code
     */
    public static void main18(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(findBalancedPoint(arr, arr.length));

    }

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
                return mid;
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
                return mid;
            else if (arr[mid] < value)
                start = mid + 1;
            else
                stop = mid - 1;
        }
        return -1;
    }

    public static int ClosestNumber(int arr[], int size, int num) {
        int start = 0;
        int stop = size - 1;
        int output = -1;
        int minDist = 9999;
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

    public static boolean DuplicateKDistance(int arr[], int size, int k) {
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

    /*
     * Testing code
     */
    public static void main66(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5 };
        DuplicateKDistance(arr, arr.length, 3);
    }

    public static void frequencyCounts(int[] arr, int size) {
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
            System.out.println((i + 1) + Math.abs(arr[i]));
    }

    public static int KLargestElements(int arrIn[], int size, int k) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = arrIn[i];

        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            if (arrIn[i] >= arr[size - k]) {
                System.out.println(arrIn[i]);
                return arrIn[i];
            }

        }
        return -1;
    }

    public static void QuickSelectUtil(int arr[], int lower, int upper, int k) {
        if (upper <= lower)
            return;

        int pivot = arr[lower];
        int start = lower;
        int stop = upper;

        while (lower < upper) {
            while (arr[lower] <= pivot) {
                lower++;
            }
            while (arr[upper] > pivot) {
                upper--;
            }
            if (lower < upper) {
                swap(arr, upper, lower);
            }
        }

        swap(arr, upper, start); // upper is the pivot position
        if (k < upper)
            QuickSelectUtil(arr, start, upper - 1, k); // pivot -1 is the upper for left sub array.
        if (k > upper)
            QuickSelectUtil(arr, upper + 1, stop, k); // pivot + 1 is the lower for right sub array.
    }

    public static int KLargestElements2(int arrIn[], int size, int k) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = arrIn[i];

        QuickSelectUtil(arr, 0, size - 1, size - k);
        for (int i = 0; i < size; i++) {
            if (arrIn[i] >= arr[size - k]) {
                System.out.println(arrIn[i]);
                return arrIn[i];
            }
        }
        return -1;
    }

    /* linear search method */
    public static int FixPoint(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == i)
                return i;
        } /* fix point not found so return invalid index */
        return -1;
    }

    /* Binary search method */
    public static int FixPoint2(int[] arr, int size) {
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

    public static int subArraySums(int arr[], int size, int value) {
        int first = 0;
        int second = 0;
        int sum = arr[first];
        while (second < size && first < size) {
            if (sum == value)
                System.out.println(first + second);

            if (sum < value) {
                second += 1;
                if (second < size)
                    sum += arr[second];
            } else {
                sum -= arr[first];
                first += 1;
            }
        }
        return sum;
    }

    public static int MaxConSub(int[] arr, int size) {
        int currMax = 0;
        int maximum = 0;
        for (int i = 0; i < size; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            if (currMax < 0)
                currMax = 0;
            if (maximum < currMax)
                maximum = currMax;
        }
        System.out.println(maximum);
        return maximum;
    }

    public static int MaxConSubArr(int[] A, int sizeA, int[] B, int sizeB) {
        int currMax = 0;
        int maximum = 0;
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < sizeB; i++)
            hs.add(B[i]);

        for (int i = 0; i < sizeA; i++)
            if (hs.contains(A[i]))
                currMax = 0;
            else
                currMax = Math.max(A[i], currMax + A[i]);
        if (currMax < 0)
            currMax = 0;
        if (maximum < currMax)
            maximum = currMax;
        System.out.println(maximum);
        return maximum;
    }

    public static int MaxConSubArr2(int A[], int sizeA, int B[], int sizeB) {
        Arrays.sort(B);
        int currMax = 0;
        int maximum = 0;

        for (int i = 0; i < sizeA; i++) {
            if (Binarysearch(B, sizeB, A[i]))
                currMax = 0;
            else {
                currMax = Math.max(A[i], currMax + A[i]);
                if (currMax < 0)
                    currMax = 0;
                if (maximum < currMax)
                    maximum = currMax;
            }
        }
        System.out.println(maximum);
        return maximum;
    }

    public static int RainWater(int[] arr, int size) {
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

    public static int RainWater2(int[] arr, int size) {
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

    public static void seperateEvenAndOdd(int[] arr, int size) {
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

    public static void main(String[] args) {
        int[] first = { 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30 };
        seperateEvenAndOdd(first, first.length);
        for (int val : first) {
            System.out.print(val + " ");
            ;
        }
    }
}