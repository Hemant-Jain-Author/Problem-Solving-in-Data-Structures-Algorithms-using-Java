public class StairUniqueWays {
	public static int stairUniqueWaysBU(int n) {
		if (n <= 2)
			return n;

		int first = 1, second = 2;
		int temp = 0;

		for (int i = 3; i <= n; i++) {
			temp = first + second;
			first = second;
			second = temp;
		}
		return temp;
	}

	public static int stairUniqueWaysBU2(int n) {
		if (n < 2)
			return n;

		int[] ways = new int[n];
		ways[0] = 1;
		ways[1] = 2;

		for (int i = 2; i < n; i++)
			ways[i] = ways[i - 1] + ways[i - 2];

		return ways[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("Unique way to reach top:: " + stairUniqueWaysBU(4));
		System.out.println("Unique way to reach top:: " + stairUniqueWaysBU2(4));
	}
}
/*
Unique way to reach top:: 5
Unique way to reach top:: 5 
*/