import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeap {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianHeap() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    // Other Methods.
    public void insert(int value) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= value) {
            maxHeap.add(value);
        } else {
            minHeap.add(value);
        }

        // size balancing
        if (maxHeap.size() > minHeap.size() + 1) {
            value = maxHeap.remove();
            minHeap.add(value);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            value = minHeap.remove();
            maxHeap.add(value);
        }
    }

    public int getMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0)
            return Integer.MAX_VALUE;

        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 10 };
        MedianHeap hp = new MedianHeap();

        for (int i = 0; i < 20; i++) {
            hp.insert(arr[i]);
            System.out.println("Median after insertion of " + arr[i] + " is  " + hp.getMedian());
        }
    }
}