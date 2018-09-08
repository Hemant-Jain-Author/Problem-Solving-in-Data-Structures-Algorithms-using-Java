public class Heap<T extends Comparable<T>> {

    private static final int CAPACITY = 32;
    private int size; // Number of elements in Heap
    private T[] arr; // The Heap array
    boolean isMinHeap;

    public Heap(boolean isMin) {
        // Java does not allow construction of array of template data types
        arr = (T[]) new Comparable[CAPACITY];
        size = 0;
        isMinHeap = isMin;
    }

    public Heap(T[] array, boolean isMin) {
        size = array.length;
        arr = array;
        isMinHeap = isMin;
        // Build Heap operation over array
        for (int i = (size / 2); i >= 0; i--) {
            proclateDown(i);
        }
    }

    // Other Methods.
    boolean compare(Comparable[] arr, int first, int second) {
        if (isMinHeap)
            return (arr[first].compareTo(arr[second]) < 0);
        return (arr[first].compareTo(arr[second]) > 0);
    }

    private void proclateDown(int position) {
        int lChild = 2 * position + 1;
        int rChild = lChild + 1;
        int small = -1;
        T temp;

        if (lChild < size) {
            small = lChild;
        }

        if (rChild < size && compare(arr, rChild, lChild)) {
            small = rChild;
        }

        if (small != -1 && compare(arr, small, position)) {
            temp = arr[position];
            arr[position] = arr[small];
            arr[small] = temp;
            proclateDown(small);
        }
    }

    private void proclateUp(int position) {
        int parent = (position - 1) / 2;
        T temp;
        if (parent == 0) {
            return;
        }

        if (compare(arr, parent, position)) {
            temp = arr[position];
            arr[position] = arr[parent];
            arr[parent] = temp;
            proclateUp(parent);
        }
    }

    public void add(T value) {
        if (size == arr.length) {
            doubleSize();
        }

        arr[size++] = value;
        proclateUp(size - 1);
    }

    private void doubleSize() {
        T[] old = arr;
        arr = (T[]) new Comparable[arr.length * 2];
        System.arraycopy(old, 0, arr, 0, size);
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        T value = arr[0];
        arr[0] = arr[size - 1];
        size--;
        proclateDown(0);
        return value;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return arr[0];
    }

    public static void HeapSort(Integer[] array, boolean inc) {
        // Create max heap for increasing order sorting.
        Heap<Integer> hp = new Heap<Integer>(array, !inc);
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = hp.remove();
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        Heap<Integer> hp = new Heap<Integer>(a, true);
        hp.print();
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(hp.remove() + " ");
        }
        System.out.println();
        Integer[] a2 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        Heap.HeapSort(a2, true);
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println();
        Integer[] a3 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        Heap.HeapSort(a3, false);
        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + " ");
        }
    }
}