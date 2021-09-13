import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestStream {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int size = 0;
    int k = 10;

    KthLargestStream(int a){
        k = a;
    }

    public void add(int value){
        if(size < k){
            pq.add(value);
        } else if (pq.peek() < value) {
                pq.add(value);
                pq.remove();
        }
        size += 1;
    }
    
    public void print(){
        System.out.println();
        System.out.println(pq);
    }

    public void add2(int value){
        if(size < k){
            pq.add(value);
            System.out.print("- ");
        } else { 
            if (pq.peek() < value) {
                pq.add(value);
                pq.remove();
            }
            System.out.print(pq.peek() + " ");
        }
        size += 1;
    }

    public static void main(String[] args) {
        KthLargestStream kt = new KthLargestStream(10);
        int value;
        Random rand = new Random(); 
        for(int i=0;i<100;i++){
            value = rand.nextInt(1000);
            //System.out.print(value + " ");
            kt.add2(value);
        }
        kt.print();
    }
}
