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

/*
Median after insertion of 1 is  1
Median after insertion of 9 is  5
Median after insertion of 2 is  2
Median after insertion of 8 is  5
Median after insertion of 3 is  3
Median after insertion of 7 is  5
Median after insertion of 4 is  4
Median after insertion of 6 is  5
Median after insertion of 5 is  5
Median after insertion of 1 is  4
Median after insertion of 9 is  5
Median after insertion of 2 is  4
Median after insertion of 8 is  5
Median after insertion of 3 is  4
Median after insertion of 7 is  5
Median after insertion of 4 is  4
Median after insertion of 6 is  5
Median after insertion of 5 is  5
Median after insertion of 10 is  5
Median after insertion of 10 is  5
*/