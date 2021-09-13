import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

public class JoinRopes {
    
    public static int joinRopes(int ropes[], int size) {
        Arrays.sort(ropes);
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            int temp = ropes[i];
            ropes[i] = ropes[j];
            ropes[j] = temp;
        }
        int total = 0;
        int value = 0;
        int index;
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
    
    public static int joinRopes2(int ropes[], int size) {
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
        System.out.println("Total : " + total);
        return total;
    }
    
    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        joinRopes(ropes, ropes.length);
        int rope2[] = { 4, 3, 2, 6 };
        joinRopes2(rope2, rope2.length);
    }
    
    /*
     * Total : 29 
     * Total : 29
     */
}