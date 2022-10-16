package LeetCodeChallenge.Oct2022.Daily;

import java.util.Arrays;

public class LC1335 {

    public static void main(String[] args) {
        int[] t = new int[]{6,5,4,3,2,1};
        System.out.println(minDifficulty(t,2));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n<d) return -1;
        int[][] dp = new int[n][d+1];
        for(int[] e:dp) Arrays.fill(e,-1);
        return recurMemo(jobDifficulty,d,0,dp);
    }



    public static int recurMemo(int[] jobDifficulty, int d, int idx, int[][] dp) {
        final int n = jobDifficulty.length;
        if (d == 0 && idx == n) return 0; //Valid case
        if (d == 0 || idx == n) return Integer.MAX_VALUE; //Fail case
        if (dp[idx][d] != -1) return dp[idx][d];
        int curMax = jobDifficulty[idx];
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < n; ++i) {
            curMax = Math.max(curMax, jobDifficulty[i]);
            int temp = recurMemo(jobDifficulty, d - 1, i + 1, dp);
            if (temp != Integer.MAX_VALUE) {
                min = Math.min(min, temp + curMax);
            }
        }
        return dp[idx][d] =min;
    }


}
