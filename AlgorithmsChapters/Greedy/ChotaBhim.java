import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

public class ChotaBhim {
    	
	public static int chotaBhim(int cups[], int size) {
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
		System.out.println("Total : " + total);
		return total;
	}
	
	public static int chotaBhim2(int cups[], int size) {
		int time = 60;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
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
	
	public static void main(String[] args) {
		int cups[] = { 2, 1, 7, 4, 2 };
		chotaBhim(cups, cups.length);
		int cups2[] = { 2, 1, 7, 4, 2 };
		chotaBhim2(cups2, cups.length);
	}
	
	/*
	 * Total : 76 
	 * Total : 76 
	 */
}
