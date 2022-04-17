
public class Queue {
    private int size;
    private int capacity;
    private int[] data;
    int front = 0;
    int back = 0;

    public Queue(int n) {
        size = 0;
        capacity = n;
        data = new int[n];
    }

    public Queue() {
        this(1000);
    }
    
	public boolean add(int value) {
        if (size >= capacity) {
            System.out.println("Queue is full.");
            return false;
        } else {
            size++;
            data[back] = value;
            back = (++back) % capacity;
        }
        return true;
    }

    public int remove() {
        int value;
        if (size <= 0) {
            System.out.println("Queue is empty.");
            return -999;
        } else {
            size--;
            value = data[front];
            front = (++front) % capacity;
        }
        return value;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void print(){
        if(size == 0) {
            System.out.print("Queue is empty.");
            return; 
        }
        int temp = front;
        int s = size;
        System.out.print("Queue is : ");
        while(s > 0){
            s--;
            System.out.print(data[temp] + " ");
            temp = (++temp) % capacity;          
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue que = new Queue();
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println("isEmpty : " + que.isEmpty());
        System.out.println("size : " + que.size());
        System.out.println("Queue remove : " + que.remove());
        System.out.println("Queue remove : " + que.remove());
    }
}

/*
isEmpty : false
size : 3
Queue remove : 1
Queue remove : 2
*/
