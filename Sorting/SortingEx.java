import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SortingEx {

public static void printArray(int[] arr, int count) {
    System.out.print("[");
    for (int i = 0; i < count; i++) {
        System.out.print(" " + arr[i]);
    }
    System.out.println(" ]");
}

public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
    return;
}

public static int partition01(int[] arr, int size) {
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

public static void partition012_(int[] arr, int size) {
    int zero = 0, one = 0, two = 0;

    for (int i =0; i < size;i++) {
        if (arr[i] == 0) {
            zero += 1;
        } else if (arr[i] == 1) {
            one += 1;
        } else {
            two += 1;
        }
    }
    int index = 0;
    while(zero > 0){
        arr[index++] = 0;
        zero -= 1;
    }
    while(one > 0){
        arr[index++] = 1;
        one -= 1;
    }
    while(two > 0){
        arr[index++] = 2;
        two -= 1;
    }
}

public static void partition012(int[] arr, int size) {
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
public static void main1() {
    int arr[] = { 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 };
    partition01(arr, arr.length);
    printArray(arr, arr.length);

    int arr2[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
    partition012(arr2, arr2.length);
    printArray(arr2, arr2.length);

    int arr3[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
    partition012_(arr3, arr3.length);
    printArray(arr3, arr3.length);
}
/*
[ 0 0 0 0 0 0 1 1 1 1 1 1 ]
[ 0 0 0 0 0 1 1 1 1 1 2 2 ]
*/
public static void rangePartition(int[] arr, int size, int lower, int higher) {
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
public static void main2() {
    int arr[] = { 1, 2, 3, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11 };
    rangePartition(arr, arr.length, 9, 12);
    printArray(arr, arr.length);
}
/*
[ 1 2 3 4 5 6 7 8 10 12 9 11 14 13 15 16 17 18 ]
*/
public static int minSwaps(int arr[], int size, int val) {
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

//Testing code
public static void main3() {
 int array[] = {1, 2, 3, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11};
 System.out.println("minSwaps " + minSwaps(array, array.length, 10));;

}
// minSwaps 3
 
public static void separateEvenAndOdd(int data[], int size) {
    int left = 0, right = size - 1;
    int[] aux = new int[size];
    
    for (int i=0;i< size;i++) {
        if (data[i] % 2 == 0) {
            aux[left] = data[i];
            left++;
        } else if (data[i] % 2 == 1) {
            aux[right] = data[i];
            right--;
        }
    }
    for (int i=0;i< size;i++)
        data[i] = aux[i];
}

public static void separateEvenAndOdd2(int data[], int size) {
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

// Testing code
public static void main4() {
    int array[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
    separateEvenAndOdd(array, array.length);
    printArray(array, array.length);
    int array2[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
    separateEvenAndOdd2(array2, array2.length);
    printArray(array2, array2.length);
}
// [ 4 6 8 2 7 3 1 9 5 ]

public static boolean absMore(int value1, int value2, int ref) {
    return (Math.abs(value1 - ref) > Math.abs(value2 - ref));
}

public static void absBubbleSort(int[] arr, int size, int ref) {
    for (int i = 0; i < (size - 1); i++) {
        for (int j = 0; j < (size - i - 1); j++) {
            if (absMore(arr[j], arr[j + 1], ref)) {
                swap(arr, j, j + 1);
            }
        }
    }
}

// Testing code
public static void main5() {
    int array[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
    int ref = 5;
    absBubbleSort(array, array.length, ref);
    printArray(array, array.length);
}
/*
[ 5 6 4 7 3 8 2 9 1 ]
*/
public static boolean eqMore(int value1, int value2, int A) {
    value1 = A * value1 * value1;
    value2 = A * value2 * value2;
    return value1 > value2;
}

public static void arrayReduction(int[] arr, int size) {
    Arrays.sort(arr);
    int count = 1;
    int reduction = arr[0];

    for (int i = 0; i < size; i++) {
        if (arr[i] - reduction > 0) {
            reduction = arr[i];
            count += 1;
            System.out.println(size - i); // after all the reduction the array will be empty.
        }
    }
    System.out.println(0);

    System.out.println("Total number of reductions: " + count);
}

// Testing code
public static void main6() {
    int arr[] = { 5, 1, 1, 1, 2, 3, 5 };
    arrayReduction(arr, arr.length);
}
// Total number of reductions: 4

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

public static void sortByOrder(int[] arr, int size, int arr2[], int size2) {
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
                System.out.print(arr2[j] + " ");
            }
            ht.remove(arr2[j]);
        }
    }

    for (int i = 0; i < size; i++) {
        if (ht.containsKey(arr[i])) {
            value = ht.get(arr[i]);
            for (int k = 0; k < value; k++) {
                System.out.print(arr[i] + " ");
            }
            ht.remove(arr[i]);
        }
    }
}

// Testing code
public static void main7() {
    int arr[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
    int arr2[] = { 2, 1, 8, 3 };
    sortByOrder(arr, arr.length, arr2, arr2.length);
    System.out.println();
}
/*
2 2 1 1 8 8 3 5 7 9 6 
*/
public static void merge(int[] arr1, int size1, int[] arr2, int size2) {
    int index = 0;
    int temp;
    while (index < size1) {
        if (arr1[index] <= arr2[0]) {
            index += 1;
        } else {
            // always first element of arr2 is compared.
            temp = arr1[index];
            arr1[index] = arr2[0];
            arr2[0] = temp;
            index += 1;
            // After swap arr2 may be unsorted.
            // Insertion of the element in proper sorted position.
            for (int i = 0; i < (size2 - 1); i++) {
                if (arr2[i] < arr2[i + 1])
                    break;
                temp = arr2[i];
                arr2[i] = arr2[i + 1];
                arr2[i + 1] = temp;
            }
        }
    }
}

// Testing code.
public static void main8() {
    int arr1[] = { 1, 5, 9, 10, 15, 20 };
    int arr2[] = { 2, 3, 8, 13 };
    merge(arr1, arr1.length, arr2, arr2.length);
    printArray(arr1, arr1.length);
    printArray(arr2, arr2.length);
}
/*
[ 1 2 3 5 8 9 ]
[ 10 13 15 20 ]
*/

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
public static void main9() {
    int arr1[] = { 1, 2, 6, 5, 4, 7};
    System.out.println(checkReverse(arr1, arr1.length));
}
// true

public static int min(int X, int Y) {
    if (X < Y) {
        return X;
    }
    return Y;
}

public static void unionIntersectionSorted(int arr1[], int size1, int arr2[], int size2) {
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

public static void unionIntersectionUnsorted(int arr1[], int size1, int arr2[], int size2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    unionIntersectionSorted(arr1, size1, arr2, size2);
}

public static void main10() {
    int arr1[] = { 1, 11, 2, 3, 14, 5, 6, 8, 9 };
    int arr2[] = { 2, 4, 5, 12, 7, 8, 13, 10 };
    unionIntersectionUnsorted(arr1, arr1.length, arr2, arr2.length);
}
/*
[ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 ]
[ 2 5 8 ]
*/
    public static void main(String[] args) {
        /*main1();
        main2();
        main3();
        main4();
        main5();
        */
        main6();
        /*main7();
        main8();
        main9();
        main10();
        */
    }
}