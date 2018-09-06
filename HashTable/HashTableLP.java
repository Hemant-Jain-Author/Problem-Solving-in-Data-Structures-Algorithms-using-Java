
public class HashTableLP {

    private static int EMPTY_NODE = -1;
    private static int DELETED_NODE = -2;
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

    int computeHash(int key) {
        return key % tableSize;
    }

    int resolverFun(int index) {
        return index;
    }

    boolean add(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_NODE || Flag[hashValue] == DELETED_NODE) {
                Arr[hashValue] = value;
                Flag[hashValue] = FILLED_NODE;
                return true;
            }
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;
    }

    boolean find(int value) {
        int hashValue = computeHash(value);
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

    boolean delete(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_NODE) {
                return false;
            }

            if (Flag[hashValue] == FILLED_NODE && Arr[hashValue] == value) {
                Flag[hashValue] = DELETED_NODE;
                return true;
            }
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;

    }

    void print() {
        for (int i = 0; i < tableSize; i++) {
            if (Flag[i] == FILLED_NODE) {
                System.out.println("Node at index [" + i + " ] :: " + Arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        HashTableLP ht = new HashTableLP(1000);
        ht.add(89);
        ht.add(18);
        ht.add(49);
        ht.add(58);
        ht.add(69);
        ht.add(89);
        ht.add(18);
        ht.add(49);
        ht.add(58);
        ht.add(69);

        ht.print();
        System.out.println("");

        ht.delete(89);
        ht.delete(18);
        ht.delete(49);
        ht.delete(58);
        ht.delete(69);
        ht.print();
    }
}