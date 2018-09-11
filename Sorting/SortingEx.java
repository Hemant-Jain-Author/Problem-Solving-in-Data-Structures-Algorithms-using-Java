import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SortingEx {

    public static void printArray(int[] arr, int count) {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.print(" ]\n");
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return;
    }

    public static int Partition01(int[] arr, int size) {
        int left = 0;
        int right = size - 1;
        int count = 0;
        while (left < right) {
            while (arr[left] == 0)
                left += 1;

            while (arr[right] == 1)
                right -= 1;

            if (left < right) {
                swap(arr, left, right);
                count += 1;
            }
        }
        return count;
    }

    public static void Partition012(int[] arr, int size) {
        int left = 0;
        int right = size - 1;
        int i = 0;
        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, i, left);
                i += 1;
                left += 1;
            } else if (arr[i] == 2) {
                swap(arr, i, right);
                right -= 1;
            } else {
                i += 1;
            }
        }
    }

    // Testing code
    public static void main1(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 };
        Partition01(arr, arr.length);
        printArray(arr, arr.length);
        int arr2[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        Partition012(arr2, arr2.length);
        printArray(arr2, arr2.length);
    }

    public static void RangePartition(int[] arr, int size, int lower, int higher) {
        int start = 0;
        int end = size - 1;
        int i = 0;
        while (i <= end) {
            if (arr[i] < lower) {
                swap(arr, i, start);
                i += 1;
                start += 1;
            } else if (arr[i] > higher) {
                swap(arr, i, end);
                end -= 1;
            } else {
                i += 1;
            }
        }
    }

    // Testing code
    public static void main3(String[] args) {
        int arr[] = { 1, 21, 2, 20, 3, 19, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11 };
        RangePartition(arr, arr.length, 9, 12);
        printArray(arr, arr.length);
    }

    int minSwaps(int arr[], int size, int val) {
        int swapCount = 0;
        int first = 0;
        int second = size - 1;
        int temp;
        while (first < second) {
            if (arr[first] <= val)
                first += 1;
            else if (arr[second] > val)
                second -= 1;
            else {
                temp = arr[first];
                arr[first] = arr[second];
                arr[second] = temp;
                swapCount += 1;
            }
        }
        return swapCount;
    }

    public static void seperateEvenAndOdd(int data[], int size) {
        int left = 0, right = size - 1;
        while (left < right) {
            if (data[left] % 2 == 0)
                left++;
            else if (data[right] % 2 == 1)
                right--;
            else {
                swap(data, left, right);
                left++;
                right--;
            }
        }
    }

    public static boolean AbsMore(int value1, int value2, int ref) {
        return (Math.abs(value1 - ref) > Math.abs(value2 - ref));
    }

    public static void AbsBubbleSort(int[] arr, int size, int ref) {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                if (AbsMore(arr[j], arr[j + 1], ref)) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Testing code
    public static void main4(String[] args) {
        int array[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        int ref = 5;
        AbsBubbleSort(array, array.length, ref);
        printArray(array, array.length);
    }

    public static boolean EqMore(int value1, int value2, int A) {
        value1 = A * value1 * value1;
        value2 = A * value2 * value2;
        return value1 > value2;
    }

    public static void ArrayReduction(int[] arr, int size) {

        Arrays.sort(arr);
        int count = 1;
        int reduction = arr[0];

        for (int i = 0; i < size; i++) {
            if (arr[i] - reduction > 0) {
                System.out.println(size - i);
                reduction = arr[i];
                count += 1;
            }
        }
        System.out.println("Total number of reductions " + count);
    }

    // Testing code
    public static void main88(String[] args) {
        int arr[] = { 5, 1, 1, 1, 2, 3, 5 };
        ArrayReduction(arr, arr.length);
    }
    /*
     * public static void SortFrequency(int[] arr, int size) { HashMap<Integer,
     * Integer> ht = new HashMap<Integer, Integer>(); int value; for (int i = 0; i <
     * size; i++) { if (ht.containsKey(arr[i])) { ht.put(arr[i], ht.get(arr[i]) +
     * 1); } else { ht.put(arr[i], 1); } } ht.sort ht.SortFrequency(arr, size);
     * 
     * // User is recommended to write his own sorting function. // For convenience
     * author is using inbuilt functions.
     * 
     * for key,value in reversed(sorted(mp.iteritems(), key = lambda (k, v):(v,k))):
     * for i in range(value): print key ,
     * 
     * // Testing code arr = [2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12] SortFrequency(arr)
     * 
     */

    public static void SortByOrder(int[] arr, int size, int arr2[], int size2) {
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        int value;
        for (int i = 0; i < size; i++) {
            if (ht.containsKey(arr[i])) {
                value = ht.get(arr[i]);
                ht.put(arr[i], value + 1);
            } else {
                ht.put(arr[i], 1);
            }
        }

        for (int j = 0; j < size2; j++) {
            if (ht.containsKey(arr2[j])) {
                value = ht.get(arr2[j]);
                for (int k = 0; k < value; k++) {
                    System.out.print(arr2[j]);
                }
                ht.remove(arr2[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            if (ht.containsKey(arr[i])) {
                value = ht.get(arr[i]);
                for (int k = 0; k < value; k++) {
                    System.out.print(arr[i]);
                }
                ht.remove(arr[i]);
            }
        }
    }

    // Testing code
    public static void main7(String[] args) {
        int arr[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
        int arr2[] = { 2, 1, 8, 3 };
        SortByOrder(arr, arr.length, arr2, arr2.length);
    }

    public static void merge(int[] arr1, int size1, int[] arr2, int size2) {
        int index = 0;
        while (index < size1) {
            if (arr1[index] <= arr2[0]) {
                index += 1;
            } else {
                // always first element of arr2 is compared.
                arr1[index] ^= arr2[0] ^= arr1[index] ^= arr2[0];
                index += 1;
                // After swap arr2 may be unsorted.
                // Insertion of the element in proper sorted position.
                for (int i = 0; i < (size2 - 1); i++) {
                    if (arr2[i] < arr2[i + 1])
                        break;
                    arr2[i] ^= arr2[i + 1] ^= arr2[i] ^= arr2[i + 1];
                }
            }
        }
    }

    // Testing code.
    public static void main9(String[] args) {
        int arr1[] = { 1, 5, 9, 10, 15, 20 };
        int arr2[] = { 2, 3, 8, 13 };
        merge(arr1, arr1.length, arr2, arr2.length);
        printArray(arr1, arr1.length);
        printArray(arr2, arr2.length);
    }

    public static boolean checkReverse(int[] arr, int size) {
        int start = -1;
        int stop = -1;
        for (int i = 0; i < (size - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1)
            return true;

        for (int i = start; i < (size - 1); i++) {
            if (arr[i] < arr[i + 1]) {
                stop = i;
                break;
            }
        }

        if (stop == -1)
            return true;

        // increasing property
        // after reversal the sub array should fit in the array.
        if (arr[start - 1] > arr[stop] || arr[stop + 1] < arr[start])
            return false;

        for (int i = stop + 1; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int min(int X, int Y) {
        if (X < Y) {
            return X;
        }
        return Y;
    }

    public static void UnionIntersectionSorted(int arr1[], int size1, int arr2[], int size2) {
        int first = 0, second = 0;
        int[] unionArr = new int[size1 + size2];
        int[] interArr = new int[min(size1, size2)];
        int uIndex = 0;
        int iIndex = 0;

        while (first < size1 && second < size2) {
            if (arr1[first] == arr2[second]) {
                unionArr[uIndex++] = arr1[first];
                interArr[iIndex++] = arr1[first];
                first += 1;
                second += 1;
            } else if (arr1[first] < arr2[second]) {
                unionArr[uIndex++] = arr1[first];
                first += 1;
            } else {
                unionArr[uIndex++] = arr2[second];
                second += 1;
            }
        }

        while (first < size1) {
            unionArr[uIndex++] = arr1[first];
            first += 1;
        }

        while (second < size2) {
            unionArr[uIndex++] = arr2[second];
            second += 1;
        }
        printArray(unionArr, uIndex);
        printArray(interArr, iIndex);
    }

    public static void UnionIntersectionUnsorted(int arr1[], int size1, int arr2[], int size2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        UnionIntersectionSorted(arr1, size1, arr2, size2);
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 11, 2, 3, 14, 5, 6, 8, 9 };
        int arr2[] = { 2, 4, 5, 12, 7, 8, 13, 10 };
        UnionIntersectionUnsorted(arr1, arr1.length, arr2, arr2.length);
    }
}