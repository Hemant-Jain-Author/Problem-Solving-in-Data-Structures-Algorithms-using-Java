package DP;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    private class Items {
        int wt;
        int cost;
        double density;

        Items(int w, int v){
            wt = w;
            cost = v;
            density = (double)cost/wt;
        }
    }
    
    class decDensity implements Comparator<Items> {
        public int compare(Items a, Items b) {
            return (int)(b.density - a.density);
        }
    }

	public double getMaxCostFractional(int[] wt, int[] cost, int capacity) {
        double totalCost = 0;
        int n = wt.length;
		Items[] itemList = new Items[n];
		for (int i = 0; i < n; i++)
			itemList[i] = new Items(wt[i], cost[i]);
        
        Arrays.sort(itemList, new decDensity());
        for (int i = 0; i < n; i++) {
            if (capacity - itemList[i].wt >= 0) {
                capacity -= itemList[i].wt;
                totalCost += itemList[i].cost;
            } else {
                totalCost += (itemList[i].density * capacity);
                break;
            }
		}
        return totalCost;
	}

    // Approximate solution.
    public double getMaxCostGreedy(int[] wt, int[] cost, int capacity) {
        double totalCost = 0;
        int n = wt.length;
		Items[] itemList = new Items[n];
		for (int i = 0; i < n; i++)
			itemList[i] = new Items(wt[i], cost[i]);
        
        Arrays.sort(itemList, new decDensity());
        for (int i = 0; i < n && capacity > 0; i++) {
            if (capacity - itemList[i].wt >= 0) {
                capacity -= itemList[i].wt;
                totalCost += itemList[i].cost;
            }
		}
        return totalCost;
	}

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] cost = { 60, 40, 90, 120 };
		int capacity = 50;

        FractionalKnapsack kp = new FractionalKnapsack();

		double maxCost = kp.getMaxCostFractional(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
        maxCost = kp.getMaxCostGreedy(wt, cost, capacity);
		System.out.println("Maximum cost obtained = " + maxCost);
	}
}

/*
Maximum cost obtained = 230.0
Maximum cost obtained = 150.0
*/