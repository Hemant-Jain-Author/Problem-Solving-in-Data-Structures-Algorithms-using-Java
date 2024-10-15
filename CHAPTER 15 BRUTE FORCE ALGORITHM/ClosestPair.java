import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ClosestPair {
	public double closestPairBF(int[][] arr) {
		int n = arr.length;
		double dmin = Double.MAX_VALUE, d;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				d = Math.sqrt((arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0])
						+ (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]));
				if (d < dmin) {
					dmin = d;
				}
			}
		}
		return dmin;
	}


	public static void main(String[] args) {
		int[][] arr = { { 648, 896 }, { 269, 879 }, { 250, 922 }, { 453, 347 }, { 213, 17 } };
		ClosestPair cp = new ClosestPair();
		System.out.println("Smallest distance is:" + cp.closestPairBF(arr));
	}
}

/*
Smallest distance is:47.01063709417264
*/
