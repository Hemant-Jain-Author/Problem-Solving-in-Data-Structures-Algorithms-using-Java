public class Heap<T extends Comparable<T>> {

    private static final int CAPACITY = 16;
    private int size; // Number of elements in heap
    private T[] arr; // The heap array

    public Heap() {
        // Java does not allow construction of array of template data types
        arr = (T[]) new Comparable[CAPACITY];
        size = 0;
    }

    public Heap(T[] array) {
        size = array.length;
        // Java does not allow construction of array of template data types
        arr = (T[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, arr, 1, array.length);// we do not use 0
                                                            // index

        // Build Heap operation over array
        for (int i = (size / 2); i > 0; i--) {
            percolateDown(i);
        }
    }
    // Other Methods.

    private void percolateDown(int position) {
        int lChild = 2 * position;
        int rChild = lChild + 1;
        int small = -1;
        T temp;

        if (lChild < size) {
            small = lChild;
        }

        if (rChild < size && arr[rChild].compareTo(arr[lChild]) < 0) {
            small = rChild;
        }

        if (small != -1 && arr[small].compareTo(arr[position]) < 0) {
            temp = arr[position];
            arr[position] = arr[small];
            arr[small] = temp;
            percolateDown(small);
        }
    }

    private void percolateUp(int position) {
        int parent = position / 2;
        T temp;
        if (parent == 0) {
            return;
        }

        if (arr[parent].compareTo(arr[position]) < 0) {
            temp = arr[position];
            arr[position] = arr[parent];
            arr[parent] = temp;
            percolateUp(parent);
        }
    }

    public void add(T value) {
        if (size == arr.length - 1) {
            doubleSize();
        }

        arr[++size] = value;
        percolateUp(size);
    }

    private void doubleSize() {
        T[] old = arr;
        arr = (T[]) new Comparable[arr.length * 2];
        System.arraycopy(old, 1, arr, 1, size);
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        T value = arr[1];
        arr[1] = arr[size];
        size--;
        percolateDown(1);
        return value;
    }

    public void print() {
        for (int i = 1; i < size; i++) {
            System.out.println("value is :: " + arr[i]);
        }

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return arr[1];
    }

    public static void heapSort(Integer[] array) {
        Heap<Integer> hp = new Heap<Integer>(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = hp.remove();
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        Heap<Integer> hp = new Heap<Integer>(a);
        hp.print();
        for (int i = 0; i < a.length; i++) {
            System.out.println("pop value :: " + hp.remove());
        }

        Heap.heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("value is :: " + a[i]);
        }
    }

}