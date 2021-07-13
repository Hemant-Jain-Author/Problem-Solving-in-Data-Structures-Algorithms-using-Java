import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ClosestPair {
    public static class Point {
        int x, y;
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    public double closestPairBF(int[][] arr) {
        int n = arr.length;
        double dmin = Double.MAX_VALUE, d;
        for (int i = 0; i < n-1 ; i++){
            for (int j = i + 1; j < n ; j++) {                
                d =  Math.sqrt((arr[i][0] - arr[j][0])*(arr[i][0] - arr[j][0]) + 
                        (arr[i][1] - arr[j][1])*(arr[i][1] - arr[j][1]));
                if (d < dmin) {
                    dmin = d;
                }
            }
        }
        return dmin;
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + 
        (a.y - b.y)*(a.y - b.y));
    }


    class xComp implements Comparator<Point> {
        public int compare(Point s1, Point s2) {
            return (s1.x - s2.x);
        }
    }
    class yComp implements Comparator<Point> {
        public int compare(Point s1, Point s2) {
            return (s1.y - s2.y);
        }
    }

    private static double stripMin(Point q[], int n, double d) {
        double min = d; 
    
        // Find the distance between all the points in the strip. 
        // Array q is sorted according to the y axis coordinate.
        // The inner loop will run at most 6 times for each point.
        for (int i = 0; i < n; ++i)
            for (int j = i+1; j < n && (q[j].y - q[i].y) < min; ++j) {
                d = distance(q[i],q[j]);
                if (d < min)
                    min = d;
            }
        return min;
    }

    private double closestPairUtil(Point p[], int start, int stop, Point q[], int n) {
        if (stop - start < 1)
            return Double.MAX_VALUE;
     
        if (stop - start == 1)
            return distance(p[start], p[stop]);

        // Find the middle point
        int mid = (start + stop)/2;
        
        double dl = closestPairUtil(p, start, mid, q, n);
        double dr = closestPairUtil(p, mid+1, stop, q, n);
        double d = Math.min(dl, dr);

        // Build an array strip[] that contains points whose x axis coordinate
        // in the range p[mid]-d and p[mid]+d
        // Points are already sorted according to y axis.
        Point[] strip = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(q[i].x - p[mid].x) < d) {
                strip[j] = q[i];
                j++;
            }
        }   
        // Find the closest points in strip and compare with d.
        return Math.min(d, stripMin(strip, j, d));
    }
    

    public double closestPairDC(int[][] arr) {
        int n = arr.length;
        Point[] p = new Point[n];
        for (int i=0; i<n; i++) {
            p[i] = new Point(arr[i][0], arr[i][1]);
        }
        // Sort according to x axis.
        Arrays.sort(p, new xComp()); 

        Point q[] = p.clone();
        // Sort according to y axis.
        Arrays.sort(q, new yComp()); 
        return closestPairUtil(p, 0, n-1,  q, n);
    }

    public static void main2(String[] args) {
        int n = 100;
        int[][] arr = new int[n][2];
        ClosestPair cp = new ClosestPair();
        double a, b;

        Random r = new Random();        
        while(true) {
            for (int i = 0; i < n; i++){
                arr[i][0] = r.nextInt(10000);
                arr[i][1] = r.nextInt(10000);
            }
            a = cp.closestPairBF(arr);
            b = cp.closestPairDC(arr);

            if(a != b){
                System.out.println("Smallest distance is:" + a); 
                System.out.println("Smallest distance is:" + b);
                System.out.print("{");
                for (int i = 0; i < n; i++) {
                    System.out.print("{" + arr[i][0] + "," +  arr[i][1]+"},");
                }   
                System.out.print("}");
                return;
            }
        }
    } 
    
    public static void main(String[] args) {
        int[][] arr ={{648,896},{269,879},{250,922},{453,347},{213,17}};
        ClosestPair cp = new ClosestPair();
        System.out.println("Smallest distance is:" + cp.closestPairBF(arr)); 
        System.out.println("Smallest distance is:" + cp.closestPairDC(arr)); 
    } 
}

/*
Smallest distance is:47.01063709417264
Smallest distance is:47.01063709417264
*/