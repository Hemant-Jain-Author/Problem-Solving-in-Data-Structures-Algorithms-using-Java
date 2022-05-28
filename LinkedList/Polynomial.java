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

	Node head;
	Node tail;
	
	Polynomial(int[] coeffs, int[] pows, int size) {
		head = null;
		tail = null;
		Node temp = null;
		for (int i = 0; i < size; i++) {
			temp = new Node(coeffs[i], pows[i]);
			if (head == null)
				head = tail = temp;
			else {
				tail.next = temp;
				tail = tail.next;
			}
		}
	}

	Polynomial() {
		this(null, null, 0);
	}

	public Polynomial add(Polynomial poly2) {
		Node p1 = head;
        Node p2 = poly2.head;
		Node temp = null;
		Polynomial poly = new Polynomial();
		while (p1 != null || p2 != null) {
			if (p1 == null || (p2 != null && p1.pow < p2.pow)) {
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

			if (poly.head == null)
				poly.head = poly.tail = temp;
			else {
				poly.tail.next = temp;
				poly.tail = poly.tail.next;
			}
		}
		return poly;
	}

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.coeff + "x^" + curr.pow);
			if (curr.next != null)
				System.out.print(" + ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int[] c1 = { 6, 5, 4 };
		int[] p1 = { 2, 1, 0 };
		int s1 = c1.length;
		Polynomial first = new Polynomial(c1, p1, s1);
		first.print();

		int[] c2 = { 3, 2, 1 };
		int[] p2 = { 3, 1, 0 };
		int s2 = c2.length;
		Polynomial second = new Polynomial(c2, p2, s2);
		second.print();

		Polynomial sum = first.add(second);
		sum.print();
	}
}

/*
6x^2 + 5x^1 + 4x^0
3x^3 + 2x^1 + 1x^0
3x^3 + 6x^2 + 7x^1 + 5x^0
*/