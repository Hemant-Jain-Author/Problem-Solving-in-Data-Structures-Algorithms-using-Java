public class NQueen {

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

	public static void main(String[] args) {
		// int[] Q= new int[8];;
		// NQueens(Q,0,8);
		TowersOfHanoi(3);
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

}
