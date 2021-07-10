package LeetCodeChallenge.JULY2021;

import java.util.Arrays;

public class LC300 {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        //An element by itself is a substring
        Arrays.fill(dp,1);
        int max = dp[0];
        for(int i=0;i<n;i++){
            for (int j = 0; j <i ; j++) {
                //if number is greater than the previous then count increases also if we have dp[i] subString
                //no need to consider the dp[j] into account
                if(nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    max= Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
