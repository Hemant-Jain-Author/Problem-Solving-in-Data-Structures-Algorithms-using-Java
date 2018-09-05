
public class HashTableLP {

	private static int EMPTY_NODE = -1;
	private static int LAZY_DELETED = -2;
	private static int FILLED_NODE = 0;

	private int tableSize;
	int[] Arr;
	int[] Flag;

	public HashTableLP(int tSize) {
		tableSize = tSize;
		Arr = new int[tSize + 1];
		Flag = new int[tSize + 1];
		for (int i = 0; i <= tSize; i++) {
			Flag[i] = EMPTY_NODE;
		}
	}

	int ComputeHash(int key) {
		return key % tableSize;
	}

	int resolverFun(int index) {
		return index;
	}

	boolean InsertNode(int value) {
		int hashValue = ComputeHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_NODE || Flag[hashValue] == LAZY_DELETED) {
				Arr[hashValue] = value;
				Flag[hashValue] = FILLED_NODE;
				return true;
			}
			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;
	}

	boolean FindNode(int value) {
		int hashValue = ComputeHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_NODE) {
				return false;
			}

			if (Flag[hashValue] == FILLED_NODE && Arr[hashValue] == value) {
				return true;
			}

			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;
	}

	boolean DeleteNode(int value) {
		int hashValue = ComputeHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (Flag[hashValue] == EMPTY_NODE) {
				return false;
			}

			if (Flag[hashValue] == FILLED_NODE && Arr[hashValue] == value) {
				Flag[hashValue] = LAZY_DELETED;
				return true;
			}
			hashValue += resolverFun(i);
			hashValue %= tableSize;
		}
		return false;

	}

	void Print() {
		for (int i = 0; i < tableSize; i++) {
			if (Flag[i] == FILLED_NODE) {
				System.out.println("Node at index [" + i + " ] :: " + Arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		HashTableLP ht = new HashTableLP(1000);
		ht.InsertNode(89);
		ht.InsertNode(18);
		ht.InsertNode(49);
		ht.InsertNode(58);
		ht.InsertNode(69);
		ht.InsertNode(89);
		ht.InsertNode(18);
		ht.InsertNode(49);
		ht.InsertNode(58);
		ht.InsertNode(69);

		ht.Print();
		System.out.println("");

		ht.DeleteNode(89);
		ht.DeleteNode(18);
		ht.DeleteNode(49);
		ht.DeleteNode(58);
		ht.DeleteNode(69);
		ht.Print();
	}
}