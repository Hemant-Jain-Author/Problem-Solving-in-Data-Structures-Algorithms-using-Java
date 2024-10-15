import java.util.Arrays;

public class CoinChange {
	static int minCoins(int[] coins, int n, int val) { // Greedy may be wrong.
		if (val <= 0)
			return 0;

		int count = 0;
		Arrays.sort(coins);

		for (int i = n - 1; i >= 0 && val > 0;) {
			if (coins[i] <= val) {
				count++;
				val -= coins[i];
			} else {
				i--;
			}
		}
		return (val == 0) ? count : -1;
	}

	static int minCoins2(int[] coins, int n, int val) { // Brute force.
		if (val == 0)
			return 0;

		int count = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (coins[i] <= val) {
				int subCount = minCoins2(coins, n, val - coins[i]);
				if (subCount >= 0)
					count = Math.min(count, subCount + 1);
			}
		}
		return (count != Integer.MAX_VALUE) ? count : -1;
	}

	static int minCoinsTD(int[] coins, int n, int val) {
		int[] count = new int[val + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0; // zero val need zero coins.
		return minCoinsTD(count, coins, n, val);
	}

	static int minCoinsTD(int[] count, int[] coins, int n, int val) {
		// Base Case
		if (count[val] != Integer.MAX_VALUE) {
			return count[val];
		}

		// Recursion
		for (int i = 0; i < n; i++) { // For all possible coins
			if (coins[i] <= val) { // check validity of a sub-problem
				int subCount = minCoinsTD(count, coins, n, val - coins[i]);
				if (subCount != Integer.MAX_VALUE && count[val] > (subCount + 1))
					count[val] = subCount + 1;
			}
		}
		return count[val];
	}

	static int minCoinsBU(int[] coins, int n, int val) { // DP bottom up approach.
		int[] count = new int[val + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0; // Base value.

		for (int i = 1; i <= val; i++) {
			for (int j = 0; j < n; j++) {
				// For all coins smaller than or equal to i.
				if (coins[j] <= i && count[i - coins[j]] != Integer.MAX_VALUE && count[i] > count[i - coins[j]] + 1) {
					count[i] = count[i - coins[j]] + 1;
				}
			}
		}
		return (count[val] != Integer.MAX_VALUE) ? count[val] : -1;
	}

	static void printCoinsUtil(int cvalue[], int val) {
		if (val > 0) {
			printCoinsUtil(cvalue, val - cvalue[val]);
			System.out.print(cvalue[val] + " ");
		}
	}

	static void printCoins(int cvalue[], int val) {
		System.out.print("Coins are : ");
		printCoinsUtil(cvalue, val);
		System.out.println();
	}

	static int minCoinsBU2(int[] coins, int n, int val) { // DP bottom up approach.
		int[] count = new int[val + 1];
		int[] cvalue = new int[val + 1];

		Arrays.fill(count, Integer.MAX_VALUE);
		Arrays.fill(cvalue, Integer.MAX_VALUE);
		count[0] = 0; // Base value.

		for (int i = 1; i <= val; i++) {
			for (int j = 0; j < n; j++) {
				// For all coins smaller than or equal to i.
				if (coins[j] <= i && count[i - coins[j]] != Integer.MAX_VALUE && count[i] > count[i - coins[j]] + 1) {
					count[i] = count[i - coins[j]] + 1;
					cvalue[i] = coins[j];
				}
			}
		}
		if (count[val] == Integer.MAX_VALUE)
			return -1;

		printCoins(cvalue, val);
		return count[val];
	}

	public static void main(String[] args) {
		int[] coins = { 5, 6 };
		int value = 16;
		int n = coins.length;
		System.out.println("Count is : " + minCoins(coins, n, value));
		System.out.println("Count is : " + minCoins2(coins, n, value));
		System.out.println("Count is : " + minCoinsTD(coins, n, value));
		System.out.println("Count is : " + minCoinsBU(coins, n, value));
		System.out.println("Count is : " + minCoinsBU2(coins, n, value));
	}
	/*
	Count is : -1
	Count is : 3
	Count is : 3
	Count is : 3
	Coins are : 6 5 5 
	Count is : 3
	*/

	public static void main1(String[] args) {
		int[] coins = { 1, 5, 6, 9, 12 };
		int value = 15;
		int n = coins.length;
		//System.out.println("Count is:" + minCoins(coins, n, value));
		//System.out.println("Count is:" + minCoins2(coins, n, value));
		System.out.println("Count is:" + minCoinsBU(coins, n, value));
		//System.out.println("Count is:" + minCoinsTD(coins, n, value));
	}

	public static void main2(String[] args) {
		int[] coins = { 1, 5, 6, 9, 11 };
		int v = 15;
		int n = coins.length;
		long first, second, third, fourth;
		// After removing sort functions performance can be compared.
		first = System.nanoTime();
		minCoins(coins, n, v);
		second = System.nanoTime();
		minCoins2(coins, n, v);
		third = System.nanoTime();
		minCoinsBU(coins, n, v);
		fourth = System.nanoTime();
		System.out.println((second - first) + " : " + (third - second) + " : " + (fourth - third));
	}
}