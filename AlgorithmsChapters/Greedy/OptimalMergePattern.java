import java.util.PriorityQueue;

public class OptimalMergePattern {
    public static int merge(int lists[], int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for (i = 0; i < size; i++) {
            pq.add(lists[i]);
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
        int lists[] = { 4, 3, 2, 6 }; 
        merge(lists, lists.length);
    }
}
