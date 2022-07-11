package LeetCodeChallenge.July2022;
/**
 *
 * Follows concept of zero one knapsack where if present we make a choice between all the options
 */

public class LC1473 {
    private int[][][] dp;
    private int MAX = 1000000000;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m+1][target+1][n+1];
        int ans = dfs(houses,cost,target,0,0,n);
        return ans==MAX?-1:ans;
    }

    private int dfs(int[] houses, int[][] cost, int target,int i,int lastColor,int n) {
        if(target<0){
            return MAX;
        }
        if(i>=houses.length){
            if(target==0) return 0;
            return MAX;
        }
        //Get from cache if present
        if(dp[i][target][lastColor]>0) return dp[i][target][lastColor];

        //House is already coloured
        if(houses[i]!=0){
            if(lastColor!=houses[i]){
                target=target-1;
            }
            return dfs(houses,cost,target,i+1,houses[i],n);
        }
        int min = MAX;
        //If house is not coloured we choose the best color just like zero one Knapsack
        for(int k=1;k<=n;k++){
            int t = lastColor==k ?0:1;
            min = Math.min(min,cost[i][k-1]+dfs(houses,cost,target-t,i+1,k,n));
        }
        dp[i][target][lastColor] = min;
        return min;
    }
}
