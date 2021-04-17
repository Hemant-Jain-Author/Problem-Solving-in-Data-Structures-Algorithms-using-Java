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

    public static void main1() {
        int[] Q = new int[8];
        nQueens(Q, 0, 8);
    }

    public static void tohUtil(int num, char from, char to, char temp) {
        if (num < 1) {
            return;
        }

        tohUtil(num - 1, from, temp, to);
        System.out.println("Move disk " + num + " from peg " + from + " to peg " + to);
        tohUtil(num - 1, temp, to, from);
    }

    public static void towersOfHanoi(int num) {
        System.out.println("The sequence of moves involved in the Tower of Hanoi are :");
        tohUtil(num, 'A', 'C', 'B');
    }

    public static void main2() {
        towersOfHanoi(3);
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

    public static void main(String[] args) {
        main1();
        main2();
    }
}

/*
 0 4 7 5 2 6 1 3 
 0 5 7 2 6 3 1 4 
 ......
 7 2 0 5 1 4 6 3 
 7 3 0 2 5 1 6 4 
 */
/*
The sequence of moves involved in the Tower of Hanoi are :
Move disk 1 from peg A to peg C
Move disk 2 from peg A to peg B
Move disk 1 from peg C to peg B
Move disk 3 from peg A to peg C
Move disk 1 from peg B to peg A
Move disk 2 from peg B to peg C
Move disk 1 from peg A to peg C
*/