package LeetCodeChallenge.Sep2022.DpPractise.Stock;

import Challenge.A;

import java.util.Arrays;

public class LC309 {


    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(prices,0,1,dp);
    }

    public int recurMemo(int[] prices,int idx,int buy,int[][] dp){
        if(idx>=prices.length) return 0;

        if(dp[idx][buy]!=-1) return dp[idx][buy];

        int profit = 0;
        if(buy==1){
            int toBuy = -prices[idx] + recurMemo(prices,idx+1,0,dp);
            int notBuy = recurMemo(prices,idx+1,1,dp);
            profit = Math.max(toBuy,notBuy);
        }
        else{
            //After selling you cannot buy again the next day so idx+2
            int toSell = prices[idx] + recurMemo(prices,idx+2,1,dp);
            int noSell = recurMemo(prices,idx+1,0,dp);
            profit = Math.max(toSell,noSell);
        }
        return dp[idx][buy] = profit;
    }


    public int tabulation(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int i=n-1;i>=0;i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int toBuy = -prices[i] + dp[i + 1][0];
                    int notBuy = dp[i + 1][1];
                    dp[i][buy] = Math.max(toBuy, notBuy);
                } else {
                    //After selling you cannot buy again the next day so idx+2
                    int toSell = prices[i] + dp[i + 2][1];
                    int noSell = dp[i + 1][0];
                    dp[i][buy] = Math.max(toSell, noSell);
                }
            }
        }
        return dp[0][1];
    }
}
