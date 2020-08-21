package LeetCode.Array;/*
 @author Myvin Barboza
 21/08/20 9:34 AM
 help :https://www.youtube.com/watch?v=oDhu5uGq_ic&feature=youtu.be
 */

public class LC123BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int prices[]={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }


    static int maxProfitSlowSolution(int[] prices) {
      int n=prices.length;
      //no of transactions
      int k=2;
      int dp[][]=new int[k+1][n];
      for(int i=1;i<dp.length;i++){
          for(int j=1;j<n;j++){
            int maxVal=0;
            for(int m=0;m<j;m++){
                maxVal=Math.max(maxVal,prices[j]-prices[m]+dp[i-1][m]);
            }
            dp[i][j]=Math.max(dp[i][j-1],maxVal);
          }
      }
      return dp[k][n-1];
    }


    static int maxProfit(int[] prices) {
        int n=prices.length;
        //no of transactions
        int k=2;
        int dp[][]=new int[k+1][n];
        for(int i=1;i<dp.length;i++){
            int maxDiff=-prices[0];
            for(int j=1;j<n;j++){
          ;
                dp[i][j]=Math.max(dp[i][j-1],maxDiff+prices[j]);
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }

}
