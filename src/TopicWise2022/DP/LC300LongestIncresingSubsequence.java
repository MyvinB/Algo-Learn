package TopicWise2022.DP;

import java.util.Arrays;

public class LC300LongestIncresingSubsequence {


    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int tail[] = new int[n];
        int size = 0;
        for(int x:nums){
            int i =0,j=size;
            while(i!=j){
                int m = i +(j-i)/2;
                if(tail[m]<x){
                    i=m+1;
                }else j=m;
            }
            tail[i] = x;
            if(i==size) size++;
        }
        return size;
    }

    public int lengthOfLISDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

}
