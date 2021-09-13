import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class HeapEx {

    public static void demo(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] arr = { 1, 2, 10, 8, 7, 3, 4, 6, 5, 9 };
    
        for (int i : arr) {
            pq.add(i);
        }
        System.out.println("Printing Priority Queue Heap : " + pq);
    
        System.out.print("Dequeue elements of Priority Queue ::");
        while (pq.isEmpty() == false) {
            System.out.print(" " + pq.remove());
        }
    }
    
    public static int kthSmallest(int[] arr, int size, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
    
    public static int kthSmallest2(int[] arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < size; i++) 
            pq.add(arr[i]);
        for (int i = 0; i < k-1; i++)
            pq.remove();
        return pq.peek();
    }
    
    public static int kthSmallest3(int[] arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < size; i++) {
            if(i < k)
                pq.add(arr[i]);
            else {
                if (pq.peek() > arr[i]) {
                    pq.add(arr[i]);
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }

    public static int kthLargest(int[] arr, int size, int k) {
        int value = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < size; i++)
            pq.add(arr[i]);
        for (int i = 0; i < k; i++)
            value = pq.remove();
        return value;
    }

    public static boolean isMinHeap(int[] arr, int size) {
        int lchild, rchild;
        // last element index size - 1
        for (int parent = 0; parent < (size / 2 + 1); parent++) {
            lchild = parent * 2 + 1;
            rchild = parent * 2 + 2;
            // heap property check.
            if (((lchild < size) && (arr[parent] > arr[lchild])) || ((rchild < size) && (arr[parent] > arr[rchild])))
                return false;
        }
        return true;
    }
    
    public static boolean isMaxHeap(int[] arr, int size) {
        int lchild, rchild;
        // last element index size - 1
        for (int parent = 0; parent < (size / 2 + 1); parent++) {
            lchild = parent * 2 + 1;
            rchild = lchild + 1;
            // heap property check.
            if (((lchild < size) && (arr[parent] < arr[lchild])) || ((rchild < size) && (arr[parent] < arr[rchild])))
                return false;
        }
        return true;
    }
    
    public static void main0(String[] args) {
        int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest :: " + kthSmallest(arr, arr.length, 3));
        int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest :: " + kthSmallest2(arr2, arr2.length, 3));
    }
    /*
    Kth Smallest :: 5
    Kth Smallest :: 5
    */
    
    public static void main1() {    
        int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("isMaxHeap :: " + isMaxHeap(arr3, arr3.length));
        int arr4[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("isMinHeap :: " + isMinHeap(arr4, arr4.length));
    }
    
    /*
    isMaxHeap :: true
    isMinHeap :: true     
    */
    public static int kSmallestProduct(int[] arr, int size, int k) {
        Arrays.sort(arr);
        int product = 1;
        for (int i = 0; i < k; i++)
            product *= arr[i];
        return product;
    }
    
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void quickSelectUtil(int[] arr, int lower, int upper, int k) {
        if (upper <= lower)
            return;
    
        int pivot = arr[lower];
        int start = lower;
        int stop = upper;
    
        while (lower < upper) {
            while (lower < upper && arr[lower] <= pivot) {
                lower++;
            }
            while (lower <= upper && arr[upper] > pivot) {
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
    
    public static int kSmallestProduct3(int[] arr, int size, int k) {
        quickSelectUtil(arr, 0, size - 1, k);
        int product = 1;
        for (int i = 0; i < k; i++)
            product *= arr[i];
        return product;
    }
    
    public static int kSmallestProduct2(int[] arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        int product = 1;
        for (i = 0; i < size; i++) {
            pq.add(arr[i]);
        }
        i = 0;
        while (i < size && i < k) {
            product *= pq.remove();
            i += 1;
        }
        return product;
    }
    
    public static int kSmallestProduct4(int[] arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());        
        for (int i = 0; i < size; i++) {
            if(i < k)
                pq.add(arr[i]);
            else {
                if (pq.peek() > arr[i]) {
                    pq.add(arr[i]);
                    pq.remove();
                }
            }
        }    
        int product = 1;
        for (int i = 0; i < k; i++) {
            product *= pq.remove();
        }
        return product;
    }

    public static void main2() {
        int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest product:: " + kSmallestProduct(arr, 8, 3));
        int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest product:: " + kSmallestProduct2(arr2, 8, 3));
        int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest product:: " + kSmallestProduct3(arr3, 8, 3));
        int arr4[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        System.out.println("Kth Smallest product:: " + kSmallestProduct4(arr4, 8, 3));
    }

    /*
     * Kth Smallest product:: 10 
     * Kth Smallest product:: 10 
     * Kth Smallest product:: 10
     * Kth Smallest product:: 10
     */
    
    public static void printLargerHalf(int[] arr, int size) {
        Arrays.sort(arr);
        for (int i = size / 2; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void printLargerHalf2(int[] arr, int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < size; i++) {
            pq.add(arr[i]);
        }
    
        for (int i = 0; i < size / 2; i++)
            pq.remove();
        System.out.println(pq);
    }
    
    public static void printLargerHalf3(int[] arr, int size) {
        quickSelectUtil(arr, 0, size - 1, size / 2);
        for (int i = size / 2; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void main3() {
        int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        printLargerHalf(arr, 8);
        int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        printLargerHalf2(arr2, 8);
        int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
        printLargerHalf3(arr3, 8);
    }

    /*
     * 6 7 7 8 
     * [6, 7, 7, 8] 
     * 6 7 7 8
     */
    
    public static void sortK(int[] arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
    
        int[] output = new int[size];
        int index = 0;
    
        for (i = k; i < size; i++) {
            output[index++] = pq.remove();
            pq.add(arr[i]);
        }
        while (pq.size() > 0)
            output[index++] = pq.remove();
    
        for (i = k; i < size; i++) {
            arr[i] = output[i];
        }
    }
    
    // Testing Code
    public static void main4() {
        int k = 3;
        int[] arr = { 1, 5, 4, 10, 50, 9 };
        int size = arr.length;
        sortK(arr, size, k);
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
    /*
     * 1 5 4 9 10 50
     */
    public static void main(String[] args) {
        main2();
    }
}

