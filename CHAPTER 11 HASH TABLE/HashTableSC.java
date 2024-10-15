import java.util.Arrays;

public class HashTableSC {

	private int tableSize;
	Node[] listArray;

	private class Node {
		private int key;
		private int value;
		private Node next;

		public Node(int k, int v, Node n) {
			key = k;
			value = v;
			next = n;
		}
	};

	public HashTableSC() {
		tableSize = 512;
		listArray = new Node[tableSize];
		Arrays.fill(listArray, null);
	}

	private int computeHash(int key) { // division method
		int hashValue = key;
		return hashValue % tableSize;
	}

	public void add(int key, int value) {
		int index = computeHash(key);
		listArray[index] = new Node(key, value, listArray[index]);
	}

	public void add(int value) {
		add(value, value);
	}

	public boolean remove(int key) {
		int index = computeHash(key);
		Node nextNode, head = listArray[index];
		if (head != null && head.key == key) {
			listArray[index] = head.next;
			return true;
		}
		while (head != null) {
			nextNode = head.next;
			if (nextNode != null && nextNode.key == key) {
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
				System.out.print("(" + head.key + "=>" +head.value + ") ");
				head = head.next;
			}
		}
		System.out.println();
	}

	public boolean find(int key) {
		int index = computeHash(key);
		Node head = listArray[index];
		while (head != null) {
			if (head.key == key) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public int get(int key) {
		int index = computeHash(key);
		Node head = listArray[index];
		while (head != null) {
			if (head.key == key) {
				return head.value;
			}
			head = head.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		HashTableSC ht = new HashTableSC();
		ht.add(1, 10);
		ht.add(2, 20);
		ht.add(3, 30);
		ht.print();
		System.out.println("Find key 2 : " + ht.find(2));
		System.out.println("Value at  key 2 : " + ht.get(2));
		ht.remove(2);
		ht.print();
		System.out.println("Find key 2 : " + ht.find(2));
	}
}
/*
Hash Table contains ::(1=>10) (2=>20) (3=>30) 
Find key 2 : true
Value at  key 2 : 20
Find key 2 : false
*/