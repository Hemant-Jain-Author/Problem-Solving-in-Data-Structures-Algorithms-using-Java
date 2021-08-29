// Towers Of Hanoi problem.
public class TOH {
    public static void tohUtil(int num, char from, char to, char temp) {
        if (num < 1) {
            return;
        }

        tohUtil(num - 1, from, temp, to);
        System.out.println("Move disk " + num + " from peg " + from + " to peg " + to);
        tohUtil(num - 1, temp, to, from);
    }

    public static void toh(int num) {
        System.out.println("The sequence of moves involved in the Tower of Hanoi are :");
        tohUtil(num, 'A', 'C', 'B');
    }

    public static void main(String[] args) {
        toh(3);
    }
}
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
