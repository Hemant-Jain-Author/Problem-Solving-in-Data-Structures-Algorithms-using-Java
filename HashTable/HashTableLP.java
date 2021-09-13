
public class HashTableLP {
    private static int EMPTY_VALUE = -1;
    private static int DELETED_VALUE = -2;
    private static int FILLED_VALUE = 0;

    private int tableSize;
    int[] array;
    int[] Flag;

    public HashTableLP(int tSize) {
        tableSize = tSize;
        array = new int[tSize + 1];
        Flag = new int[tSize + 1];
        for (int i = 0; i <= tSize; i++) {
            Flag[i] = EMPTY_VALUE;
        }
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
    
    boolean add(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_VALUE || Flag[hashValue] == DELETED_VALUE) {
                array[hashValue] = value;
                Flag[hashValue] = FILLED_VALUE;
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
            if (Flag[hashValue] == EMPTY_VALUE) {
                return false;
            }
    
            if (Flag[hashValue] == FILLED_VALUE && array[hashValue] == value) {
                return true;
            }
    
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;
    }
    
    boolean remove(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_VALUE) {
                return false;
            }
    
            if (Flag[hashValue] == FILLED_VALUE && array[hashValue] == value) {
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
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HashTableLP ht = new HashTableLP(1000);
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