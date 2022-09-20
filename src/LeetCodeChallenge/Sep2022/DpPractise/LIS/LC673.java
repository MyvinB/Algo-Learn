package LeetCodeChallenge.Sep2022.DpPractise.LIS;

import java.util.Arrays;

public class LC673 {

    public static void main(String[] args) {
        int[] t = new int[]{100,90,80,70,60,50,60,70,80,90,100};
        int[] p = new int[]{1,2,3,1,2,3,1,2,3};
        System.out.println(findNumberOfLIS(p));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //Already there increase count
                    if (dp[i] == 1 + dp[j]) {
                        //increment
                        count[i] += count[j];
                    }else if(dp[j]+1>dp[i]) //reset only when we find something bigger that is inherit whatever count of j
                        count[i] = count[j];
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ct = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) ct += count[i];
        }
        return ct;

    }


}
