package Greedy;
// Activities selection problem.
import java.util.*;

// Prints a maximum set of activities that can be done by a 
// single person performing one task at a time.
// s[] is an array that contains start time of all activities
// f[] is an array that contains finish time of all activities

class ActivitySelection {
    class Activity implements Comparable<Activity> {
        int start, stop;

        Activity(int s, int f){
            start = s;
            stop = f;
        }

        public int compareTo(Activity s2) {
            return this.stop - s2.stop;
        }
    }

    public void maxActivities(int s[], int f[], int n) {
        Activity[] act = new Activity[n];
        for(int i =0;i< n;i++)
            act[i] = new Activity(s[i], f[i]);
        Arrays.sort(act); // sort according to finish time.

        int i = 0; // The first activity at index 0 is always gets selected.
        System.out.print("Activities are : (" + act[i].start + "," + act[i].stop + ")" );

        for (int j = 1; j < n; j++) {
            // Find next activity whose start time is greater than or equal
            // to the finish time of previous activity.
            if (act[j].start >= act[i].stop) {
                System.out.print(", (" + act[j].start + "," + act[j].stop + ")");
                i = j;
            }
        }
    }
 
    public static void main(String[] args) {
        int s[] = {1, 5, 0, 3, 5, 6, 8};
        int f[] = {2, 6, 5, 4, 9, 7, 9};
        int n = s.length;
        ActivitySelection as = new ActivitySelection();
        as.maxActivities(s, f, n);
    }    
}

/*
Activities are : (1,2), (3,4), (5,6), (6,7), (8,9)
*/