package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC300 {

    public static void main(String[] args) {
        int[] t = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(t));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(nums,0,-1,dp);
    }

    public static int recurMemo(int[] nums,int idx,int prevIdx,int[][] dp){
        if(idx==nums.length) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx];
        int take = 0;
        int noTake = recurMemo(nums,idx+1,prevIdx,dp);
        if(  prevIdx==-1|| nums[idx]>nums[prevIdx]){
            take = 1 + recurMemo(nums,idx+1,nums[idx],dp);
        }
        return dp[idx][prevIdx+1] =  Math.max(take,noTake);
    }
}
