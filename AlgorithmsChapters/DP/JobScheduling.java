import java.util.Arrays;
import java.util.Comparator;
// Also known as Activity Selection Weighted.
public class JobScheduling {
    public static class Job implements Comparable<Job>  {
        int start, stop, value;

        Job(int s, int f, int v){
            start = s;
            stop = f;
            value = v;
        }

        public int compareTo(Job j2) {
            return this.stop - j2.stop;
        }
    }

    public static int maxValueJobUtil(Job[] arr, int n) {
        // Base case
        if (n == 1) 
            return arr[0].value;
     
        // Find Value when current job is included
        int incl = arr[n-1].value;
        for (int j=n-1; j>=0; j--) {
            if (arr[j].stop <= arr[n-1].start) {
                incl += maxValueJobUtil(arr, j+1); 
                break;   
            }
        }    
     
        // Find Value when current job is excluded
        int excl = maxValueJobUtil(arr, n-1);
     
        return Math.max(incl,  excl);
    }


    public static int maxValueJobs(int s[], int f[], int[] v, int n) {
        Job[] act = new Job[n];
        for(int i =0;i< n;i++)
            act[i] = new Job(s[i], f[i], v[i]);
        Arrays.sort(act); // sort according to finish time.
        return maxValueJobUtil(act, n);
    }
    
    public static int maxValueJobUtilTD(int[] dp, Job[] arr, int n) {
        // Base case
        if (n == 0) 
            return 0;
        
        if (dp[n-1] != 0) {
            return dp[n-1];
        }
     
        // Find Value when current job is included
        int incl = arr[n-1].value;
        for (int j=n-2; j>=0; j--) {
            if (arr[j].stop <= arr[n-1].start) {
                incl += maxValueJobUtilTD(dp, arr, j+1); 
                break;   
            }
        }    
     
        // Find Value when current job is excluded
        int excl = maxValueJobUtilTD(dp, arr, n-1);
        dp[n-1] = Math.max(incl,  excl); 
        return dp[n-1];
    }


    public static int maxValueJobsTD(int s[], int f[], int[] v, int n) {
        Job[] act = new Job[n];
        for(int i =0;i< n;i++)
            act[i] = new Job(s[i], f[i], v[i]);
        Arrays.sort(act); // sort according to finish time.
        int[] dp = new int[n];
        return maxValueJobUtilTD(dp, act, n);
    }

    public static int maxValueJobsBU(int s[], int f[], int[] v, int n) {
        Job[] act = new Job[n];
        for(int i =0;i< n;i++)
            act[i] = new Job(s[i], f[i], v[i]);
        Arrays.sort(act); // sort according to finish time.
        int[] dp = new int[n];
        dp[0] = act[0].value;;
        
        for (int i=1; i<n; i++) {
            int incl = act[i].value;
            for (int j=i-1; j>=0; j--) {
                if (act[j].stop <= act[i].start) {
                    incl += dp[j]; 
                    break;   
                }
            }    
            dp[i] = Math.max(incl, dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int start[] =  {1, 5, 0, 3, 5, 6, 8};
        int finish[] = {2, 6, 5, 4, 9, 7, 9};
        int value[] =  {2, 2, 4, 3, 10, 2, 8};  
        int n = start.length;
        System.out.println(maxValueJobs(start, finish, value, n));
        System.out.println(maxValueJobsTD(start, finish, value, n));
        System.out.println(maxValueJobsBU(start, finish, value, n));
    }       
}