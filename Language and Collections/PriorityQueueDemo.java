import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueueDemo {

	class less implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	}

	class more implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b.compareTo(a);
		}
	}

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int[] arr = { 1, 2, 10, 8, 7, 3, 4, 6, 5, 9 };
		for (int i : arr) 
			pq.add(i);
		
		System.out.println("Printing Heap : " + pq);
		while (pq.isEmpty() == false) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();

		pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i : arr) 
			pq.add(i);
		
		System.out.println("Printing Heap : " + pq);
		while (pq.isEmpty() == false) {
			System.out.print(pq.remove() + " ");
		}
	}
}
/* 
Printing Heap : [1, 2, 3, 5, 7, 10, 4, 8, 6, 9]
1 2 3 4 5 6 7 8 9 10 
Printing Heap : [10, 9, 4, 6, 8, 2, 3, 1, 5, 7]
10 9 8 7 6 5 4 3 2 1
 */