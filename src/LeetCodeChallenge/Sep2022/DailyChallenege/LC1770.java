package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC1770 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] multi = new int[]{3,2,1};
        System.out.println(maximumScore(nums,multi));
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(nums,multipliers,0,nums.length-1,0,dp);
    }

    public static int recurMemo(int[] nums,int[] multipliers,int frontIdx,int backIdx,int multiIdx,int[][] dp){
        //Base case
        if(frontIdx==nums.length || backIdx==-1 || multiIdx==multipliers.length) return 0;
        if(dp[frontIdx][backIdx]!=-1) return dp[frontIdx][backIdx];
        //Choosing the front index
        int front  = nums[frontIdx] * multipliers[multiIdx] + recurMemo(nums,multipliers,frontIdx+1,backIdx,multiIdx+1,dp);
        int back  = nums[backIdx] * multipliers[multiIdx] + recurMemo(nums,multipliers,frontIdx,backIdx-1,multiIdx+1,dp);
        return dp[frontIdx][backIdx]  = Math.max(front,back);
    }


    public static int tabulation(int[] nums,int[] multipliers){
        int n = nums.length;
        int m = multipliers.length;
        int[][][] dp = new int[m+1][n+1][n+1];
        int front = 0;
        int back = n-1;
        for(int i=0;i<=m;i++){
            int frontScore = front<n? (nums[front] * multipliers[i] + dp[i+1][front+1][back]):0;
            int backScore =back>0? (nums[back] * multipliers[i] + dp[i+1][front][back-1]):0;
            dp[i][front][back] = Math.max(frontScore,backScore);
            if(dp[i][front][back]==frontScore) front++;
            if(dp[i][front][back]==backScore) back--;
        }
        return dp[0][0][n-1];
    }
}
