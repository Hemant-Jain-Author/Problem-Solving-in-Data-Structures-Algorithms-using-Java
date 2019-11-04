import java.util.HashMap;
import java.util.Arrays;

public class Introduction {

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

    public static int SumArray(int[] arr) {
        int size = arr.length;
        int total = 0;
        for (int index = 0; index < size; index++) {
            total = total + arr[index];
        }
        return total;
    }

    public static void main0(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Sum of values in array:" + SumArray(arr));
    }

    public void function2() {
        System.out.println("fun2 line 1");
    }

    public void function1() {
        System.out.println("fun1 line 1");
        function2();
        System.out.println("fun1 line 2");
    }

    public void main2() {
        System.out.println("main line 1");
        function1();
        System.out.println("main line 2");
    }

    public static int SequentialSearch(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int size, int value) {
        int mid;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            mid = low + (high - low) / 2; // To avoid the overflow
            if (arr[mid] == value) {
                return mid;
            } else {
                if (arr[mid] < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main3(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Sum of values in array:" + SequentialSearch(arr, arr.length, 7));
        System.out.println("Sum of values in array:" + BinarySearch(arr, arr.length, 7));
    }

    public static void rotateArray(int[] a, int n, int k) {
        reverseArray(a, 0, k - 1);
        reverseArray(a, k, n - 1);
        reverseArray(a, 0, n - 1);
    }

    public static void reverseArray(int[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void reverseArray2(int[] a) {
        int start = 0;
        int end = a.length - 1;
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void main4(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        rotateArray(arr, arr.length, 2);
        printArray(arr, arr.length);
    }

    public static int maxSubArraySum(int[] a, int size) {
        int maxSoFar = 0, maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + a[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    public static void main5(String[] args) {
        int[] arr = { 1, -2, 3, 4, -4, 6, -4, 3, 2 };
        System.out.println("Max sub array sum :" + maxSubArraySum(arr, 9));
    }

    public static void WaveArray2(int[] arr) {
        int size = arr.length;
        /* Odd elements are lesser then even elements. */
        for (int i = 1; i < size; i += 2) {
            if ((i - 1) >= 0 && arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
            }
            if ((i + 1) < size && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }
    
    public static void WaveArray(int[] arr)
    { 
        int size = arr.length; 
        Arrays.sort(arr); 
        printArray(arr, arr.length);
        for(int i = 0 ; i < size -1 ; i+= 2) {
            swap(arr, i, i+1); 
        } 
    }
    

    /* Testing code */
    public static void main6(String[] args) {
        int[] arr = { 8, 1, 2, 3, 4, 5, 6, 4, 2 };
        printArray(arr, arr.length);
        WaveArray(arr);
        printArray(arr, arr.length);
        int[] arr2 = { 8, 1, 2, 3, 4, 5, 6, 4, 2 };
        WaveArray2(arr2);
        printArray(arr2, arr2.length);
    }

    public static void indexArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            int curr = i;
            int value = -1;

            /* swaps to move elements in proper position. */
            while (arr[curr] != -1 && arr[curr] != curr) {
                int temp = arr[curr];
                arr[curr] = value;
                value = curr = temp;
            }

            /* check if some swaps happened. */
            if (value != -1) {
                arr[curr] = value;
            }
        }
    }

    public static void indexArray2(int[] arr, int size) {
        int temp;
        for (int i = 0; i < size; i++) {
            while (arr[i] != -1 && arr[i] != i) {
                /* swap arr[i] and arr[arr[i]] */
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
    }

    /* Testing code */
    public static void main7(String[] args) {
        int[] arr = { 8, -1, 6, 1, 9, 3, 2, 7, 4, -1 };
        int size = arr.length;
        indexArray2(arr, size);
        printArray(arr, size);
        int[] arr2 = { 8, -1, 6, 1, 9, 3, 2, 7, 4, -1 };
        size = arr2.length;
        indexArray(arr2, size);
        printArray(arr2, size);
    }

    public static void Sort1toN(int[] arr, int size) {
        int curr, value, next;
        for (int i = 0; i < size; i++) {
            curr = i;
            value = -1;
            /* swaps to move elements in proper position. */
            while (curr >= 0 && curr < size && arr[curr] != curr + 1) {
                next = arr[curr];
                arr[curr] = value;
                value = next;
                curr = next - 1;
            }
        }
    }

    public static void Sort1toN2(int[] arr, int size) {
        int temp;
        for (int i = 0; i < size; i++) {
            while (arr[i] != i + 1 && arr[i] > 1) {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
    }

    public static void main8(String[] args) {
        int[] arr = { 8, 5, 6, 1, 9, 3, 2, 7, 4, 10 };
        int size = arr.length;
        Sort1toN2(arr, size);
        printArray(arr, size);
        int[] arr2 = { 8, 5, 6, 1, 9, 3, 2, 7, 4, 10 };
        size = arr2.length;
        Sort1toN(arr2, size);
        printArray(arr2, size);

    }

    public static int SmallestPositiveMissingNumber(int[] arr, int size) {
        int found;
        for (int i = 1; i < size + 1; i++) {
            found = 0;
            for (int j = 0; j < size; j++) {
                if (arr[j] == i) {
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int SmallestPositiveMissingNumber2(int[] arr, int size) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            hs.put(arr[i], 1);
        }
        for (int i = 1; i < size + 1; i++) {
            if (hs.containsKey(i) == false) {
                return i;
            }
        }
        return -1;
    }

    public static int SmallestPositiveMissingNumber3(int[] arr, int size) {
        int[] aux = new int[size];
        Arrays.fill(aux, -1);

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0 && arr[i] <= size) {
                aux[arr[i] - 1] = arr[i];
            }
        }
        for (int i = 0; i < size; i++) {
            if (aux[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int SmallestPositiveMissingNumber4(int[] arr, int size) {
        int temp;
        for (int i = 0; i < size; i++) {
            while (arr[i] != i + 1 && arr[i] > 0 && arr[i] <= size) {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main9(String[] args) {
        int[] arr = { 8, 5, 6, 1, 9, 11, 2, 7, 4, 10 };
        int size = arr.length;

        System.out.println("Max sub array sum :" + SmallestPositiveMissingNumber(arr, size));
        System.out.println("Max sub array sum :" + SmallestPositiveMissingNumber2(arr, size));
        System.out.println("Max sub array sum :" + SmallestPositiveMissingNumber3(arr, size));
        System.out.println("Max sub array sum :" + SmallestPositiveMissingNumber4(arr, size));
    }

    public static void MaxMinArr(int arr[], int size) {
        int[] aux = Arrays.copyOf(arr, size);
        int start = 0;
        int stop = size - 1;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                arr[i] = aux[stop];
                stop -= 1;
            } else {
                arr[i] = aux[start];
                start += 1;
            }
        }
    }

    public static void ReverseArr(int arr[], int start, int stop) {
        while (start < stop) {
            swap(arr, start, stop);
            start += 1;
            stop -= 1;
        }
    }

    public static void MaxMinArr2(int arr[], int size) {
        for (int i = 0; i < (size - 1); i++) {
            ReverseArr(arr, i, size - 1);
        }
    }

    /* Testing code */
    public static void main10(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int size = arr.length;
        MaxMinArr(arr, size);
        printArray(arr, size);
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        int size2 = arr.length;
        MaxMinArr2(arr2, size2);
        printArray(arr2, size2);
    }

    public static int maxCircularSum(int[] arr, int size) {
        int sumAll = 0;
        int currVal = 0;
        int maxVal;

        for (int i = 0; i < size; i++) {
            sumAll += arr[i];
            currVal += (i * arr[i]);
        }
        maxVal = currVal;
        for (int i = 1; i < size; i++) {
            currVal = (currVal + sumAll) - (size * arr[size - i]);
            if (currVal > maxVal) {
                maxVal = currVal;
            }
        }
        return maxVal;
    }

    /* Testing code */
    public static void main11(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("MaxCirculrSm: " + maxCircularSum(arr, arr.length));
    }

    public static int ArrayIndexMaxDiff(int[] arr, int size) {
        int maxDiff = -1;
        int j;
        for (int i = 0; i < size; i++) {
            j = size - 1;
            while (j > i) {
                if (arr[j] > arr[i]) {
                    maxDiff = Math.max(maxDiff, j - i);
                    break;
                }
                j -= 1;
            }
        }
        return maxDiff;
    }

    public static int ArrayIndexMaxDiff2(int[] arr, int size) {
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        leftMin[0] = arr[0];
        int i, j;
        int maxDiff;
        for (i = 1; i < size; i++) {
            if (leftMin[i - 1] < arr[i]) {
                leftMin[i] = leftMin[i - 1];
            } else {
                leftMin[i] = arr[i];
            }
        }
        rightMax[size - 1] = arr[size - 1];
        for (i = size - 2; i >= 0; i--) {
            if (rightMax[i + 1] > arr[i]) {
                rightMax[i] = rightMax[i + 1];
            } else {
                rightMax[i] = arr[i];
            }
        }
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < size && i < size) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }
        }
        return maxDiff;
    }

    /*
    public static int ArrayIndexMaxDiff3(int arr[], int size) { 
        int[] leftMin = new int[size]; 
        int[] rightMax = new int[size]; 
        int minIndex = 0, maxIndex = 0; 
        int i, j; 
        int maxDiff; 
        leftMin[minIndex++] = 0;
        for (i = 1; i < size; i++)
        {
         if (arr[leftMin[minIndex]] > arr[i]) { 
             leftMin[minIndex++] = i; 
            } 
        }
     
        rightMax[maxIndex++] = size - 1; 
        for (i = size - 2; i >= 0; i--) { 
            if (arr[rightMax[maxIndex]] < arr[i]) { 
                rightMax[maxIndex++] = i; 
            } 
        }
     
        i = 0; 
        j = maxIndex - 1; 
        maxDiff = -1;
     
        while (i < minIndex && j >= 0) { 
            if (arr[leftMin[i]] < arr[rightMax[j]]) {
                maxDiff = Math.max(maxDiff, rightMax[j] - leftMin[i]); 
                j -= 1; 
            } else { 
                i += 1; 
            } 
        } 
        return maxDiff; 
    }
    */
    public static void main(String[] args) {
        int[] arr = { 33, 9, 10, 3, 2, 60, 30, 33, 1 };
        System.out.println("ArrayIndexMaxDiff : " + ArrayIndexMaxDiff(arr, arr.length));
        System.out.println("ArrayIndexMaxDiff : " + ArrayIndexMaxDiff2(arr, arr.length));
      //  System.out.println("ArrayIndexMaxDiff : " + ArrayIndexMaxDiff3(arr, arr.length));
    }

    public static int maxPathSum(int[] arr1, int size1, int[] arr2, int size2) {
        int i = 0, j = 0, result = 0, sum1 = 0, sum2 = 0;

        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i += 1;
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j += 1;
            } else {
                result += Math.max(sum1, sum2);
                result = result + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i += 1;
                j += 1;
            }
        }
        while (i < size1) {
            sum1 += arr1[i];
            i += 1;
        }

        while (j < size2) {
            sum2 += arr2[j];
            j += 1;
        }

        result += Math.max(sum1, sum2);
        return result;
    }

    /* Testing code */
    public static void main13(String[] args) {
        int[] arr1 = { 12, 13, 18, 20, 22, 26, 70 };
        int[] arr2 = { 11, 15, 18, 19, 20, 26, 30, 31 };
        System.out.println("Max Path Sum :: " + maxPathSum(arr1, arr1.length, arr2, arr2.length));
    }

    public int factorial(int i) {
        // Termination Condition
        if (i <= 1) {
            return 1;
        }
        // Body, Recursive Expansion
        return i * factorial(i - 1);
    }

    ///////////////
    public void printInt1(int number) {
        char digit = (char) (number % 10 + '0');
        number = number / 10;
        if (number != 0) {
            printInt1(number);
        }
        System.out.print("%c" + digit);
    }

    public void printInt(int number) {
        String conversion = "0123456789ABCDEF";
        int base = 16;
        char digit = (char) (number % base);
        number = number / base;
        if (number != 0) {
            printInt(number);
        }
        System.out.print(conversion.charAt(digit));
    }

    public static void towerOfHanoi(int num, char src, char dst, char temp) {
        if (num < 1) {
            return;
        }

        towerOfHanoi(num - 1, src, temp, dst);
        System.out.println("Move " + num + " disk  from peg " + src + " to peg " + dst);
        towerOfHanoi(num - 1, temp, dst, src);
    }

    public static void main14(String[] args) {
        int num = 4;
        System.out.println("The sequence of moves involved in the Tower of Hanoi are :\n");
        towerOfHanoi(num, 'A', 'C', 'B');
    }

    public static int GCD(int m, int n) {
        if (m < n) {
            return (GCD(n, m));
        }
        if (m % n == 0) {
            return (n);
        }
        return (GCD(n, m % n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void permutation(int[] arr, int i, int length) {
        if (length == i) {
            printArray(arr, length);
            return;
        }
        int j = i;
        for (j = i; j < length; j++) {
            swap(arr, i, j);
            permutation(arr, i + 1, length);
            swap(arr, i, j);
        }
        return;
    }

    public static void main15(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        permutation(arr, 0, 5);
    }

    // Binary Search Algorithm - Recursive
    public static int BinarySearchRecursive(int[] arr, int low, int high, int value) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return BinarySearchRecursive(arr, mid + 1, high, value);
        } else {
            return BinarySearchRecursive(arr, low, mid - 1, value);
        }
    }

    /* Testing code */
    public static void main16(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(BinarySearchRecursive(arr, 0, arr.length - 1, 6));
        System.out.println(BinarySearchRecursive(arr, 0, arr.length - 1, 16));
    }

}