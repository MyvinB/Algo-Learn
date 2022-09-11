package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC1383 {

    public static void main(String[] args) {

    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<n;i++){
            ess[i][0] = efficiency[i];
            ess[i][1] = speed[i];
        }
        Arrays.sort(ess,(a,b)->b[0]-a[0]);
        long sumS = 0,ans = 0;
        for(int[] a:ess){
            //Offering the speed
            pq.offer(a[1]);
            sumS+= a[1];
            while(pq.size()>k) sumS -= pq.poll();
            ans = Math.max(ans,a[0]*sumS);
        }
        return (int)(ans%(long)(1e9+7));
    }
}
