import java.util.*;
import java.util.Collections;
import java.util.Arrays;

public class JobSequencing {
    Job jobs[];
    int n;
    int maxDL;

    static class Job{
        char id;
        int deadline, profit;
        
        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }    
    }
    
    public JobSequencing(char[] ids, int[] deadlines, int[] profits, int n) {
        this.jobs = new Job[n];
        this.n = n;
        this.maxDL = deadlines[0];
        for(int i = 1;i <n;i++){
            if(deadlines[i] > this.maxDL)
                this.maxDL = deadlines[i];
        }

        for(int i=0;i<n;i++){
            this.jobs[i] = new Job(ids[i], deadlines[i], profits[i]);
        }
    }    

    void print(){
        Arrays.sort(this.jobs, (a, b) -> b.profit - a.profit);
        boolean result[] = new boolean[this.maxDL];
        char job[] = new char[this.maxDL];
        int profit = 0;

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            for (int j = this.jobs[i].deadline  - 1; j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = this.jobs[i].id;
                    profit += this.jobs[i].profit;
                    break;
                }
            }
        }
        System.out.println("Profit is :: " + profit);
        System.out.print("Jobs selected are::");
        for(int i=0;i< this.maxDL;i++)
            if(job[i] != '\u0000')
                System.out.print(" " + job[i]);
    }


    public static void main(String args[]) {
        char id[] = {'a', 'b', 'c', 'd', 'e'};
        int deadline[] = {3, 1, 2, 4, 4};
        int profit[] = {50, 40, 27, 31, 30};
        JobSequencing js = new JobSequencing(id, deadline, profit, 5);
        js.print();
    }
}

/*
Profit is :: 151
Jobs selected are:: b e a d
*/