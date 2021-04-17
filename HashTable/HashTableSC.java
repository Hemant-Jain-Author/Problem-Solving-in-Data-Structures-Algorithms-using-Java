public class HashTableSC {

    private int tableSize;
    Node[] listArray;

    private class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    };

    public HashTableSC() {
        tableSize = 512;
        listArray = new Node[tableSize];
        for (int i = 0; i < tableSize; i++) {
            listArray[i] = null;
        }
    }

    private int computeHash(int key)// division method
    {
        int hashValue = key;
        return hashValue % tableSize;
    }

    public void add(int value) {
        int index = computeHash(value);
        listArray[index] = new Node(value, listArray[index]);
    }

    public boolean remove(int value) {
        int index = computeHash(value);
        Node nextNode, head = listArray[index];
        if (head != null && head.value == value) {
            listArray[index] = head.next;
            return true;
        }
        while (head != null) {
            nextNode = head.next;
            if (nextNode != null && nextNode.value == value) {
                head.next = nextNode.next;
                return true;
            } else {
                head = nextNode;
            }
        }
        return false;
    }

    public void print() {
        System.out.print("Hash Table contains ::");
        for (int i = 0; i < tableSize; i++) {
            Node head = listArray[i];
            while (head != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
        }
        System.out.println();
    }

    public boolean find(int value) {
        int index = computeHash(value);
        Node head = listArray[index];
        while (head != null) {
            if (head.value == value) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HashTableSC ht = new HashTableSC();
        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.print();
        System.out.println("Find key 2 : " + ht.find(2));
        ht.remove(2);
        System.out.println("Find key 2 : " + ht.find(2));
    }
}
/*
Hash Table contains ::1 2 3 
Find key 2 : true
Find key 2 : false
*/