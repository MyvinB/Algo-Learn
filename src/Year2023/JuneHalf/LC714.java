package Year2023.JuneHalf;

import java.util.Arrays;

public class LC714 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3,2,8,4,9};
        System.out.println(maxProfit(t,2));
        System.out.println(tabulation(t,2));
    }

    ///Using recursion
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(prices,fee,0,1,dp);
    }

    public static int recurMemo(int[] prices, int fee, int idx, int buy,int[][] dp){
        if(idx==prices.length) return 0;
        int profit = 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            int toBuy = -prices[idx] + recurMemo(prices,fee,idx+1,0,dp);
            int noBuy = recurMemo(prices,fee,idx+1,1,dp);
            profit = Math.max(toBuy,noBuy);
        }
        else{
            int toSell = prices[idx]- fee + recurMemo(prices,fee,idx+1,1,dp);
            int noSell = recurMemo(prices,fee,idx+1,0,dp);
            profit = Math.max(toSell,noSell);
        }
        return dp[idx][buy]=profit;
    }

    public static int tabulation(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    int toBuy = -prices[i] +dp[i+1][0];
                    int noBuy = dp[i+1][1];
                    dp[i][buy] = Math.max(toBuy,noBuy);
                }
                else{
                    int toSell = prices[i]-fee + dp[i+1][1];
                    int noSell = dp[i+1][0];
                    dp[i][buy] = Math.max(toSell,noSell);
                }
            }
        }
        return dp[0][1];
    }
}
