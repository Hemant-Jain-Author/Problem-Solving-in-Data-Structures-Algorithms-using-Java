
public class HeapEx {

    void Sort(int[] arr, int size, int inc) {
        HeapSort(arr, size, inc);
    }

    int KthSmallest(int[] arr, int size, int k) {
        Sort(arr, size, 1);
        return arr[k - 1];
    }

    int KthSmallest2(int[] arr, int size, int k)
    {
        Heap hp;
        HeapInitialize(&hp, arr, size, 1);
        int i = 0;
        int value = 0;
        while (i < size && i < k)
        {
            value = HeapRemove(&hp);
            i += 1;
        }
        return value;
    }

    int isMinHeap(int[] arr, int size) {
        int lchild, rchild;
        // last element index size - 1
        for (int parent = 0; parent < (size / 2 + 1); parent++) {
            lchild = parent * 2 + 1;
            rchild = parent * 2 + 2;
            // heap property check.
            if (((lchild < size) && (arr[parent] > arr[lchild])) || ((rchild < size) && (arr[parent] > arr[rchild])))
                return 0;
        }
        return 1;
    }

    int isMaxHeap(int[] arr, int size) {
        int lchild, rchild;
        // last element index size - 1
        for (int parent = 0; parent < (size / 2 + 1); parent++) {
            lchild = parent * 2 + 1;
            rchild = lchild + 1;
            // heap property check.
            if (((lchild < size) && (arr[parent] < arr[lchild])) || ((rchild < size) && (arr[parent] < arr[rchild])))
                return 0;
        }
        return 1;
    }

public static void main2()
{
    int arr[] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("Kth Smallest :: %d\n", KthSmallest(arr, 8, 3));
    int arr2[] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("Kth Smallest :: %d\n", KthSmallest2(arr2, 8, 3));
    int arr3[] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("isMaxHeap :: %d\n", isMaxHeap(arr3, sizeof(arr) / sizeof(int)));
    int arr4[] = {8, 7, 6, 5, 7, 5, 2, 1};
    Sort(arr4, sizeof(arr) / sizeof(int), 1);
    printf("isMinHeap :: %d\n", isMinHeap(arr4, sizeof(arr) / sizeof(int)));
    return 0;
}

    int KSmallestProduct(int[] arr, int size, int k) {
        Sort(arr, size, 1);
        int product = 1;
        for (int i = 0; i < k; i++)
            product *= arr[i];
        return product;
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void QuickSelectUtil(int arr[], int lower, int upper, int k) {
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

    int KSmallestProduct3(int[] arr, int size, int k) {
        QuickSelectUtil(arr, 0, size - 1, k);
        int product = 1;
        for (int i = 0; i < k; i++)
            product *= arr[i];
        return product;
    }

int KSmallestProduct2(int[] arr, int size, int k)
{
    Heap hp;
    HeapInitialize(&hp, arr, size, 1);
    int i = 0;
    int product = 1;
    while (i < size && i < k)
    {
        product *= HeapRemove(&hp);
        i += 1;
    }
    return product;
}

public static void main3()
{
    int arr[] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("Kth Smallest product:: %d\n",
           KSmallestProduct(arr, 8, 3));
    int arr2[] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("Kth Smallest product:: %d\n",
           KSmallestProduct2(arr2, 8, 3));
    int arr3[8] = {8, 7, 6, 5, 7, 5, 2, 1};
    printf("Kth Smallest product:: %d\n",
           KSmallestProduct3(arr3, 8, 3));
    return 0;
}

    void PrintLargerHalf(int[] arr, int size) {
        Sort(arr, size, 1);
        for (int i = size / 2; i < size; i++)
            printf("%d ", arr[i]);
        printf("\n");
    }

void PrintLargerHalf2(int[] arr, int size)
{
    Heap hp;
    HeapInitialize(&hp, arr, size, 1);
    for (int i = 0; i < size / 2; i++)
        HeapRemove(&hp);
    Printarray(arr, size / 2);
}

    void PrintLargerHalf3(int[] arr, int size) {
        QuickSelectUtil(arr, 0, size - 1, size / 2);
        for (int i = size / 2; i < size; i++)
            printf("%d ", arr[i]);
        printf("\n");
    }

public static void main4()
{
    int arr[] = {8, 7, 6, 5, 7, 5, 2, 1};
    PrintLargerHalf(arr, 8);
    int arr2[] = {8, 7, 6, 5, 7, 5, 2, 1};
    PrintLargerHalf2(arr2, 8);
    int arr3[8] = {8, 7, 6, 5, 7, 5, 2, 1};
    PrintLargerHalf3(arr3, 8);
    return 0;
}

void sortK(int[] arr, int size, int k)
{
    Heap hp;
    HeapInitialize(&hp, arr, k, 1);

    int *output = (int *)malloc(sizeof(int) * size);
    int index = 0;

    for (int i = k; i < size; i++)
    {
        output[index++] = HeapRemove(&hp);
        HeapAdd(&hp, arr[i]);
    }
    while (Heapsize(&hp) > 0)
        output[index++] = HeapRemove(&hp);

    for (int i = k; i < size; i++)
    {
        arr[i] = output[i];
    }
    Printarray(output, index);
}

    // Testing Code
public static void main5()
{
    int k = 3;
    int arr[] = {1, 5, 4, 10, 50, 9};
    int size = sizeof(arr) / sizeof(int);
    sortK(arr, size, k);
    return 0;
}

    int ChotaBhim(int cups[], int size) {
        int time = 60;
        Sort(cups, size, 0);
        int total = 0;
        int index, temp;
        while (time > 0) {
            total += cups[0];
            cups[0] = ceil(cups[0] / 2.0);
            index = 0;
            temp = cups[0];
            while (index < size - 1 && temp < cups[index + 1]) {
                cups[index] = cups[index + 1];
                index += 1;
            }
            cups[index] = temp;
            time -= 1;
        }
        printf("Total %d ", total);
        return total;
    }

    int ChotaBhim2(int cups[], int size) {
        int time = 60;
        Sort(cups, size, 0);
        int total = 0;
        int i, temp;
        while (time > 0) {
            total += cups[0];
            cups[0] = ceil(cups[0] / 2.0);
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
        printf("Total : %d\n", total);
        return total;
    }

int ChotaBhim3(int cups[], int size)
{
    int time = 60;
    Heap hp;
    HeapInitialize(&hp, cups, size, 0);
    int total = 0;
    int value;
    while (time > 0)
    {
        value = HeapRemove(&hp);
        total += value;
        value = ceil(value / 2.0);
        HeapAdd(&hp, value);
        time -= 1;
    }
    printf("Total : %d\n", total);
    return total;
}

    int JoinRopes(int ropes[], int size) {
        Sort(ropes, size, 0);
        Printarray(ropes, size);
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
        printf("Total : %d \n", total);
        return total;
    }

int JoinRopes2(int ropes[], int size)
{
    Heap hp;
    HeapInitialize(&hp, ropes, size, 1);
    int total = 0;
    int value = 0;
    while (Heapsize(&hp) > 1)
    {
        value = HeapRemove(&hp);
        value += HeapRemove(&hp);
        HeapAdd(&hp, value);
        total += value;
    }
    printf("Total : %d ", total);
    return total;
}

public static void main6()
{
    int cups[] = {2, 1, 7, 4, 2};
    ChotaBhim(cups, sizeof(cups) / sizeof(int));
    int cups2[] = {2, 1, 7, 4, 2};
    ChotaBhim2(cups2, sizeof(cups) / sizeof(int));
    int cups3[] = {2, 1, 7, 4, 2};
    ChotaBhim3(cups3, sizeof(cups) / sizeof(int));

    int ropes[] = {2, 1, 7, 4, 2};
    JoinRopes(ropes, sizeof(ropes) / sizeof(int));
    int rope2[] = {2, 1, 7, 4, 2};
    JoinRopes2(rope2, sizeof(rope2) / sizeof(int));

    return 0;
}

    /*
     * int kthAbsDiff(int[] arr, int size, int k) { Sort(arr, size, 1); int
     * diff[100];// = malloc(); int index = 0; for (int i = k + 1; i < size - 1;
     * i++) { for (int j = i + 1; j < size; j++) diff[index++] = abs(arr[i] -
     * arr[j]); } Sort(diff, size, 1); return diff[k - 1]; }
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
     * public static void main7() { int arr[] = { 1, 2, 3, 4 }; printf("",
     * kthAbsDiff(arr, 4, 5)); return 0; }
     */

int kthLargestStream(int k)
{
    Heap hp;
    HeapInitialize2(&hp, 100, 1);
    int size = 0;
    int data;
    while (1)
    {
        printf("Enter data: ");
        scanf("%d", &data);

        if (size < k - 1)
            HeapAdd(&hp, data);
        else
        {
            if (size == k - 1)
                HeapAdd(&hp, data);
            else if (HeapTop(&hp) < data)
            {
                HeapAdd(&hp, data);
                HeapRemove(&hp);
            }
            printf("Kth larges element is :: ", HeapTop(&hp));
        }
        size += 1;
    }
}

    public static void main7() {
        kthLargestStream(3);
        return 0;
    }
    /*
     * int minJumps(int[] arr, int size) { int *jumps = (int *)malloc(sizeof(int) *
     * size); //all jumps to maxint. int steps, j; jumps[0] = 0;
     * 
     * for (int i = 0; i < size; i++) { steps = arr[i]; // error checks can be added
     * hear. j = i + 1; while (j <= i + steps && j < size) { jumps[j] =
     * min(jumps[j], jumps[i] + 1); j += 1; } printf("%s", jumps); } return
     * jumps[size - 1]; } public static void main2() { int arr[] = {1, 4, 3, 7, 6,
     * 1, 0, 3, 5, 1, 10}; printf("%d", minJumps(arr, sizeof(arr) / sizeof(int)));
     * return 0; }
     */

    #

    define ERROR_VALUE 999999

    typedef struct medianHeap
    {
        Heap minHeap;
        Heap maxHeap;
    }MedianHeap;

void MedianHeapInit(MedianHeap *heap)
{
    HeapInitialize2(&heap->minHeap, 100, 1);
    HeapInitialize2(&heap->maxHeap, 100, 0);
}

void MedianHeapAdd(MedianHeap *heap, int value)
{
    if (Heapsize(&heap->maxHeap) == 0 || HeapTop(&heap->maxHeap) >= value)
    {
        HeapAdd(&heap->maxHeap, value);
    }
    else
    {
        HeapAdd(&heap->minHeap, value);
    }
    //size balancing
    if (Heapsize(&heap->maxHeap) > Heapsize(&heap->minHeap) + 1)
    {
        value = HeapRemove(&heap->maxHeap);
        HeapAdd(&heap->minHeap, value);
    }
    if (Heapsize(&heap->minHeap) > Heapsize(&heap->maxHeap) + 1)
    {
        value = HeapRemove(&heap->minHeap);
        HeapAdd(&heap->maxHeap, value);
    }
}

int getMedian(MedianHeap *heap)
{
    if (Heapsize(&heap->maxHeap) == 0 && Heapsize(&heap->minHeap) == 0)
        return ERROR_VALUE;

    if (Heapsize(&heap->maxHeap) == Heapsize(&heap->minHeap))
        return (HeapTop(&heap->maxHeap) + HeapTop(&heap->minHeap)) / 2;
    else if (Heapsize(&heap->maxHeap) > Heapsize(&heap->minHeap))
        return HeapTop(&heap->maxHeap);
    else
        return HeapTop(&heap->minHeap);
}

public static void main()
{
    int arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5, 1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 10};

    MedianHeap heap;
    MedianHeapInit(&heap);
    for (int i = 0; i < 20; i++)
    {
        MedianHeapAdd(&heap, arr[i]);
        printf("Median after insertion of %d is %d \n", arr[i], getMedian(&heap));
    }
    return 0;
}
}