public class algo {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        int first = 0;
        int second = 1;
        int temp = 0;

        if (n == 0)
            return first;
        else if (n == 1)
            return second;
        int i = 2;
        while (i <= n) {
            temp = first + second;
            first = second;
            second = temp;
            i += 1;
        }
        return temp;
    }

    public static void print(int[] Q, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" " + Q[i]);
        }
        System.out.println(" ");
    }

    public static boolean Feasible(int[] Q, int k) {
        for (int i = 0; i < k; i++) {
            if (Q[k] == Q[i] || Math.abs(Q[i] - Q[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void NQueens(int[] Q, int k, int n) {
        if (k == n) {
            print(Q, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            Q[k] = i;
            if (Feasible(Q, k)) {
                NQueens(Q, k + 1, n);
            }
        }
    }

    public static void main1(String[] args) {
        int[] Q = new int[8];
        NQueens(Q, 0, 8);
    }

    public static void TOHUtil(int num, char from, char to, char temp) {
        if (num < 1) {
            return;
        }

        TOHUtil(num - 1, from, temp, to);
        System.out.println("Move disk " + num + " from peg " + from + " to peg " + to);
        TOHUtil(num - 1, temp, to, from);
    }

    public static void TowersOfHanoi(int num) {
        System.out.println("The sequence of moves involved in the Tower of Hanoi are :");
        TOHUtil(num, 'A', 'C', 'B');
    }

    public static void main2(String[] args) {
        TowersOfHanoi(3);
    }

    int isPrime(int n) {
        int answer = (n > 1) ? 1 : 0;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}