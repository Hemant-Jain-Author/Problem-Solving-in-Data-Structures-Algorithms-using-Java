
import java.util.Arrays;

public class HashTableLP {
	private static int EMPTY_VALUE = -1;
	private static int DELETED_VALUE = -2;
	private static int FILLED_VALUE = 0;

	private int tableSize;
	int[] Key;
	int[] Value;
	int[] Flag;

	public HashTableLP(int tSize) {
		tableSize = tSize;
		Key = new int[tSize + 1];
		Value = new int[tSize + 1];
		Flag = new int[tSize + 1];
		Arrays.fill(Flag, EMPTY_VALUE);
	}

	/* Other Methods */

	int computeHash(int key) {
		return key % tableSize;
	}

	int resolverFun(int index) {
		return index;
	}

	int resolverFun2(int index) {
		return index * index;
	}

	boolean add(int key, int value) {
		int hashValue = computeHash(key);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_VALUE || Flag[hashValue] == DELETED_VALUE) {
				Key[hashValue] = key;
				Value[hashValue] = value;
				Flag[hashValue] = FILLED_VALUE;
				return true;
			}
			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;
	}

	boolean add(int value) {
		return add(value, value);
	}

	boolean find(int key) {
		int hashValue = computeHash(key);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_VALUE) {
				return false;
			}

			if (Flag[hashValue] == FILLED_VALUE && Key[hashValue] == key) {
				return true;
			}
			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;
	}

	int get(int key) {
		int hashValue = computeHash(key);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_VALUE) {
				return -1;
			}

			if (Flag[hashValue] == FILLED_VALUE && Key[hashValue] == key) {
				return Value[hashValue];
			}

			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return -1;
	}

	boolean remove(int key) {
		int hashValue = computeHash(key);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_VALUE) {
				return false;
			}

			if (Flag[hashValue] == FILLED_VALUE && Key[hashValue] == key) {
				Flag[hashValue] = DELETED_VALUE;
				return true;
			}
			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;
	}

	void print() {
		System.out.print("Hash Table contains ::");
		for (int i = 0; i < tableSize; i++) {
			if (Flag[i] == FILLED_VALUE) {
				System.out.print("(" + Key[i] + "=>" + Value[i] + ") ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HashTableLP ht = new HashTableLP(1000);
		ht.add(1, 10);
		ht.add(2, 20);
		ht.add(3, 30);
		ht.print();
		System.out.println("Find key 2 : " + ht.find(2));
		System.out.println("Value at  key 2 : " + ht.get(2));
		ht.remove(2);
		System.out.println("Find key 2 : " + ht.find(2));
	}
}

/*
Hash Table contains ::(1=>10) (2=>20) (3=>30) 
Find key 2 : true
Value at  key 2 : 20
Find key 2 : false
*/