public class NQueen {
    public static void print(int[] Q, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" " + Q[i]);
        }
        System.out.println(" ");
    }

    public static boolean feasible(int[] Q, int k) {
        for (int i = 0; i < k; i++) {
            if (Q[k] == Q[i] || Math.abs(Q[i] - Q[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(int[] Q, int k, int n) {
        if (k == n) {
            print(Q, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            Q[k] = i;
            if (feasible(Q, k)) {
                nQueens(Q, k + 1, n);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] Q = new int[8];
        nQueens(Q, 0, 8);
    }
}

/*
 0 4 7 5 2 6 1 3 
 0 5 7 2 6 3 1 4 
 ......
 7 2 0 5 1 4 6 3 
 7 3 0 2 5 1 6 4 
 */