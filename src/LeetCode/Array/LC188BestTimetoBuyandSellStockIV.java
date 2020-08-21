package LeetCode.Array;/*
 @author Myvin Barboza
 21/08/20 10:43 AM 
 */

public class LC188BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0) return 0;
        int n=prices.length;
        //no of transactions
        if(k>=prices.length){
            return solve(prices);
        }
        int dp[][]=new int[k+1][n];
        for(int i=1;i<dp.length;i++){
            int maxDiff=-prices[0];
            for(int j=1;j<n;j++){

                dp[i][j]=Math.max(dp[i][j-1],maxDiff+prices[j]);
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }


    public static int solve(int a[]){
        int profit = 0;
        for (int i =1; i <a.length ; i++) {
            if(a[i]>a[i-1]){
                profit+=a[i]-a[i-1];
            }
        }
        return profit;
    }
}
