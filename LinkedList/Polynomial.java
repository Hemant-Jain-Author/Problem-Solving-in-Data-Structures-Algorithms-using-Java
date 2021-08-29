public class Polynomial {
    public static class Node {
        int coeff;
        int pow;
        Node next;
        Node(int c, int p) {
            coeff = c;
            pow = p;
            next = null;
        }
    }

    public static Node add(Node p1, Node p2) {
        Node head=null, tail=null, temp=null;
        while (p1 != null || p2 != null) {
            if (p1 == null || p1.pow < p2.pow) {
                temp = new Node(p2.coeff, p2.pow);
                p2 = p2.next;
            } else if (p2 == null || p1.pow > p2.pow) {
                temp = new Node(p1.coeff, p1.pow);
                p1 = p1.next;
            } else if (p1.pow == p2.pow) {
                temp = new Node(p1.coeff + p2.coeff, p1.pow);
                p1 = p1.next;
                p2 = p2.next;
            }

            if(head == null)
                head = tail = temp;
            else {
                tail.next = temp;
                tail=tail.next;
            }
        }
        return head;
    }

    public static Node create(int[] coeffs, int[] pows, int size) {
        Node head=null, tail=null, temp=null;
        for (int i=0; i < size; i++) {
            temp = new Node(coeffs[i], pows[i]);
            if(head == null)
                head = tail = temp;
            else {
                tail.next = temp;
                tail=tail.next;
            }
        }
        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.coeff + "x^" + head.pow);
            if (head.next != null)
                System.out.print(" + ");
                head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        int[] c1 = { 6, 5, 4 };
        int[] p1 = { 2, 1, 0 };
        int s1 = c1.length;
        Node first = create(c1, p1, s1);
        print(first);

        int[] c2 = { 3, 2, 1 };
        int[] p2 = { 3, 1, 0 };
        int s2 = c2.length;
        Node second = create(c2, p2, s2);
        print(second);

        Node sum = add(first, second);
        print(sum);
    }
}

/*
3x^3 + 6x^2 + 7x^1 + 5x^0
*/