import java.util.ArrayDeque;

public class QueueDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println("Queue : "+que);
        System.out.println("Queue size : "+que.size());
        System.out.println("Queue peek : "+que.peek());
        System.out.println("Queue remove : "+que.remove());
        System.out.println("Queue isEmpty : "+que.isEmpty());
    }
}