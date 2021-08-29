
public class Queue {
    private int size;
    private int capacity = 100;
    private int[] data;
    int front = 0;
    int back = 0;

    public Queue(int n) {
        size = 0;
        capacity = n;
        data = new int[n];
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
        Queue que = new Queue(5);
        for(int i=0;i<5;i++){
            que.add(i);
        }
        que.print();

        for (int i = 0; i < 5; i++)
            System.out.print(que.remove() + " ");
    }
}

/*
Queue is : 0 1 2 3 4 
0 1 2 3 4 
*/