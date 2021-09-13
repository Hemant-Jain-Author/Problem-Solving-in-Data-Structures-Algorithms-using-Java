import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] arr = { 1, 2, 10, 8, 7, 3, 4, 6, 5, 9 };
        for (int i : arr)
            pq.add(i);
        
        System.out.println("Heap Array: " + pq);
        while (pq.isEmpty() == false)
            System.out.print(pq.remove() + " ");
        System.out.println();

        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i : arr)
            pq.add(i);
        
        System.out.println("Heap Array: " + pq);
        while (pq.isEmpty() == false)
            System.out.print(pq.remove() + " ");
    }
}

/* 
Heap Array: [1, 2, 3, 5, 7, 10, 4, 8, 6, 9]
1 2 3 4 5 6 7 8 9 10 
Heap Array: [10, 9, 4, 6, 8, 2, 3, 1, 5, 7]
10 9 8 7 6 5 4 3 2 1
 */