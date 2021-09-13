package DP;
import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
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
        @Override
        public int compare(Items a, Items b) {
            return (int)(b.density - a.density);
        }
    }

    // Approximate solution.
    public int getMaxCostGreedy(int[] wt, int[] cost, int capacity) {
        int totalCost = 0;
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

        Knapsack kp = new Knapsack();
        int maxCost = kp.getMaxCostGreedy(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
    }
}

/*
Maximum cost obtained = 150
*/