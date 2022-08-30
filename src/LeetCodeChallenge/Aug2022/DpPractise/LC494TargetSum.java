package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;

public class LC494TargetSum {

    public static void main(String args[]) {

        int arr[] = {1,1,1,1,1};
        int k=3;

        System.out.println("The number of subsets found are "+findTargetSumWays(arr,k));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return recurMemo(nums,target,n-1,dp);
    }


    public static int recurMemo(int[] nums, int sum, int idx, int[][] dp){
        if(sum==0) return 1;
        if(idx == 0) return nums[0] == sum?1:0;
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        int noTake = recurMemo(nums,sum,idx-1,dp);
        int take = 0;
        if(nums[idx]<=sum) take = recurMemo(nums,sum-nums[idx],idx-1,dp);
        return dp[idx][sum] = take+noTake;
    }

    public static int tabulationSpaceOpti(int[] nums,int target){
        int n = nums.length;
        int[] dp = new int[target+1];
        //if target == 0;
        dp[0] = 1;
        //if idx==0 and target==a[0]
        if(nums[0]<=target) dp[nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                if(j>=nums[i])
                    dp[j] += dp[j-nums[i]];
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }


}
