import java.util.PriorityQueue;
import java.util.Arrays;

public class HeapEx {

public static void demo(String[] args) {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    // PriorityQueue<Integer> pq = new
    // PriorityQueue<Integer>(Collections.reverseOrder());
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

public static int KthSmallest(int[] arr, int size, int k) {
    Arrays.sort(arr);
    return arr[k - 1];
}

public static int KthSmallest2(int[] arr, int size, int k) {
    int i = 0;
    int value = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (i = 0; i < size; i++) {
        pq.add(arr[i]);
    }

    while (i < size && i < k) {
        value = pq.remove();
        i += 1;
    }
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

public static void main2(String[] args) {
    int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("Kth Smallest :: " + KthSmallest(arr, arr.length, 3));
    int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("Kth Smallest :: " + KthSmallest2(arr2, arr2.length, 3));
    int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("isMaxHeap :: " + isMaxHeap(arr3, arr3.length));
    int arr4[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    Arrays.sort(arr4);
    System.out.println("isMinHeap :: " + isMinHeap(arr4, arr4.length));
}

public static int KSmallestProduct(int[] arr, int size, int k) {
    Arrays.sort(arr);// , size, 1);
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

public static void QuickSelectUtil(int[] arr, int lower, int upper, int k) {
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
        QuickSelectUtil(arr, start, upper - 1, k); // pivot -1 is the upper for left sub array.
    if (k > upper)
        QuickSelectUtil(arr, upper + 1, stop, k); // pivot + 1 is the lower for right sub array.
}

public static int KSmallestProduct3(int[] arr, int size, int k) {
    QuickSelectUtil(arr, 0, size - 1, k);
    int product = 1;
    for (int i = 0; i < k; i++)
        product *= arr[i];
    return product;
}

public static int KSmallestProduct2(int[] arr, int size, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int i = 0;
    int product = 1;
    for (i = 0; i < size; i++) {
        pq.add(arr[i]);
    }

    while (i < size && i < k) {
        product *= pq.remove();
        i += 1;
    }
    return product;
}

public static void main3(String[] args) {
    int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("Kth Smallest product:: " + KSmallestProduct(arr, 8, 3));
    int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("Kth Smallest product:: " + KSmallestProduct2(arr2, 8, 3));
    int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    System.out.println("Kth Smallest product:: " + KSmallestProduct3(arr3, 8, 3));
}

public static void PrintLargerHalf(int[] arr, int size) {
    Arrays.sort(arr);// , size, 1);
    for (int i = size / 2; i < size; i++)
        System.out.print(arr[i]);
    System.out.println();
}

public static void PrintLargerHalf2(int[] arr, int size) {
    int product = 1;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < size; i++) {
        pq.add(arr[i]);
    }

    for (int i = 0; i < size / 2; i++)
        pq.remove();
    System.out.println(pq);
}

public static void PrintLargerHalf3(int[] arr, int size) {
    QuickSelectUtil(arr, 0, size - 1, size / 2);
    for (int i = size / 2; i < size; i++)
        System.out.print(arr[i]);
    System.out.println();
}

public static void main4(String[] args) {
    int arr[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    PrintLargerHalf(arr, 8);
    int arr2[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    PrintLargerHalf2(arr2, 8);
    int arr3[] = { 8, 7, 6, 5, 7, 5, 2, 1 };
    PrintLargerHalf3(arr3, 8);
}

public static void sortK(int[] arr, int size, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int i = 0;
    for (i = 0; i < size; i++) {
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
    System.out.println(output);
}

// Testing Code
public static void main5(String[] args) {
    int k = 3;
    int[] arr = { 1, 5, 4, 10, 50, 9 };
    int size = arr.length;
    sortK(arr, size, k);
}

public static int ChotaBhim(int cups[], int size) {
    int time = 60;
    Arrays.sort(cups);
    int total = 0;
    int index, temp;
    while (time > 0) {
        total += cups[0];
        cups[0] = (int) Math.ceil(cups[0] / 2.0);
        index = 0;
        temp = cups[0];
        while (index < size - 1 && temp < cups[index + 1]) {
            cups[index] = cups[index + 1];
            index += 1;
        }
        cups[index] = temp;
        time -= 1;
    }
    System.out.println("Total %d " + total);
    return total;
}

public static int ChotaBhim2(int cups[], int size) {
    int time = 60;
    Arrays.sort(cups);
    int total = 0;
    int i, temp;
    while (time > 0) {
        total += cups[0];
        cups[0] = (int) Math.ceil(cups[0] / 2.0);
        i = 0;
        // Insert into proper location.
        while (i < size - 1) {
            if (cups[i] > cups[i + 1])
                break;
            temp = cups[i];
            cups[i] = cups[i + 1];
            cups[i + 1] = temp;
            i += 1;
        }
        time -= 1;
    }
    System.out.println("Total : " + total);
    return total;
}

public static int ChotaBhim3(int cups[], int size) {
    int time = 60;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int i = 0;
    for (i = 0; i < size; i++) {
        pq.add(cups[i]);
    }

    int total = 0;
    int value;
    while (time > 0) {
        value = pq.remove();
        total += value;
        value = (int) Math.ceil(value / 2.0);
        pq.add(value);
        time -= 1;
    }
    System.out.println("Total : " + total);
    return total;
}

public static int JoinRopes(int ropes[], int size) {
    Arrays.sort(ropes);
    System.out.println(ropes);
    int total = 0;
    int value = 0;
    int temp, index;
    int length = size;

    while (length >= 2) {
        value = ropes[length - 1] + ropes[length - 2];
        total += value;
        index = length - 2;

        while (index > 0 && ropes[index - 1] < value) {
            ropes[index] = ropes[index - 1];
            index -= 1;
        }
        ropes[index] = value;
        length--;
    }
    System.out.println("Total : " + total);
    return total;
}

public static int JoinRopes2(int ropes[], int size) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int i = 0;
    for (i = 0; i < size; i++) {
        pq.add(ropes[i]);
    }

    int total = 0;
    int value = 0;
    while (pq.size() > 1) {
        value = pq.remove();
        value += pq.remove();
        pq.add(value);
        total += value;
    }
    System.out.println("Total : %d " + total);
    return total;
}

public static void main6(String[] args) {
    int cups[] = { 2, 1, 7, 4, 2 };
    ChotaBhim(cups, cups.length);
    int cups2[] = { 2, 1, 7, 4, 2 };
    ChotaBhim2(cups2, cups.length);
    int cups3[] = { 2, 1, 7, 4, 2 };
    ChotaBhim3(cups3, cups.length);

    int ropes[] = { 2, 1, 7, 4, 2 };
    JoinRopes(ropes, ropes.length);
    int rope2[] = { 2, 1, 7, 4, 2 };
    JoinRopes2(rope2, rope2.length);
}

/*
    * public static int kthAbsDiff(int[] arr, int size, int k) { Sort(arr, size,1);
    * int diff[1000]; int index = 0; for (int i = 0; i < size - 1; i++) { for (int
    * j = i + 1; j < size; j++) diff[index++] = abs(arr[i] - arr[j]); } Sort(diff,
    * index); return diff[k - 1]; }
    * 
    * int kthAbsDiff(int[] arr, int size, int k) { Sort(arr, size, 1); Heap hp; int
    * value = 0;
    * 
    * for (int i = k + 1; i < size - 1; i++) HeapAdd(&hp,(abs(arr[i] - arr[i + 1]),
    * i, i + 1)); heapify(hp);
    * 
    * for (int i = 0; i < k; i++) { tp = heapq.heappop(hp); value = tp[0]; src =
    * tp[1]; dst = tp[2]; if (dst + 1 < size) heapq.heappush(hp, (abs(arr[src] -
    * arr[dst + 1]), src, dst + 1)); } return value; }
    * 
    * public static void main7(String[] args) { int arr[] = { 1, 2, 3, 4 };
    * System.out.println("", kthAbsDiff(arr, 4, 5)); return 0; }
    */
public static int kthLargestStream(int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int size = 0;
    int data = 0;
    while (true) {
        System.out.println("Enter data: ");
        // data = System.in.read();

        if (size < k - 1)
            pq.add(data);
        else {
            if (size == k - 1)
                pq.add(data);
            else if (pq.peek() < data) {
                pq.add(data);
                pq.remove();
            }
            System.out.println("Kth larges element is :: " + pq.peek());
        }
        size += 1;
    }
}

public static void main(String[] args) {
    kthLargestStream(3);
}
/*
    * public static int minJumps(int[] arr, int size) { int *jumps = (int
    * *)malloc(sizeof(int) * size); //all jumps to maxint. int steps, j; jumps[0] =
    * 0;
    * 
    * for (int i = 0; i < size; i++) { steps = arr[i]; // error checks can be added
    * hear. j = i + 1; while (j <= i + steps && j < size) { jumps[j] =
    * min(jumps[j], jumps[i] + 1); j += 1; } System.out.println("%s", jumps); }
    * return jumps[size - 1]; } public static void main2(String[] args) { int arr[]
    * = {1, 4, 3, 7, 6, 1, 0, 3, 5, 1, 10}; System.out.println("%d", minJumps(arr,
    * sizeof(arr) / sizeof(int))); return 0; }
    */
}