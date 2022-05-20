package TopicWise2022.DP;

public class LC188BestTimeToBuyAndSellStockKtransactions {

    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k>=n){
            int p =0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]) p+= prices[i]-prices[i+1];
            }
            return p;
        }
        int dp[][] = new int[k+1][n];
        for(int i=1;i<=k;i++){
            int maxDiff = 0;
            for(int j=0;j<n;j++){
                //Not transaction at all on the jth day
                dp[i][j] = Math.max(dp[i][j-1],maxDiff+prices[j]);
                maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }


}
