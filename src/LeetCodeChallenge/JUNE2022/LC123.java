package LeetCodeChallenge.JUNE2022;

public class LC123 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        //https://www.youtube.com/watch?v=oDhu5uGq_ic
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[k+1][n];
        for(int i=1;i<=k;i++){
            //maxDiff first time you buy have to resert with every iteration
            int maxDiff = -prices[0];
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i][j-1],maxDiff+prices[j]);
                maxDiff = Math.max(maxDiff,dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
}
