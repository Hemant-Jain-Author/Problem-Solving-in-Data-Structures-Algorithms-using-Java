import java.util.PriorityQueue;
import java.util.Comparator;

public class HuffmanTree {
    Node root = null;

    class Node implements Comparable<Node> {
        char c;
        int freq;
        Node left;
        Node right;
    
        Node(char ch, int fr, Node l, Node r) {
            c = ch; 
            freq = fr;
            left = l;
            right = r;
        }

        public int compareTo(Node n2) {
            return this.freq - n2.freq;
        }
    }

    HuffmanTree(char[] arr, int[] freq){
        int n = arr.length;
        PriorityQueue<Node> que = new PriorityQueue<Node>(n);

        for (int i = 0; i < n; i++) {
            Node node = new Node(arr[i], freq[i], null, null);
            que.add(node);
        }

        while (que.size() > 1) {
            Node lt= que.peek();
            que.poll();
            Node rt = que.peek();
            que.poll();
      
            Node nd = new Node('+', lt.freq + rt.freq, lt, rt);      
            que.add(nd);
        }
        root = que.peek();      
    }

    private void print(Node root, String s) {
        if (root.left == null && root.right == null && root.c != '+') {
            System.out.println(root.c + " = " + s);
            return;
        }
        print(root.left, s + "0");
        print(root.right, s + "1");
    }

    public void print(){
        System.out.println("Char = Huffman code");
        print(root, "");
    }

    public static void main(String[] args) {
        char[] ar = { 'A', 'B', 'C', 'D', 'E' };
        int[] fr = { 30, 25, 21, 14, 10};
        HuffmanTree hf = new HuffmanTree(ar, fr);
        hf.print();    
    }
}

/*
Char = Huffman code
C = 00
E = 010
D = 011
B = 10
A = 11
*/