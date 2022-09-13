package LeetCodeChallenge.Sep2022.DpPractise.Stock;

import java.util.Arrays;

public class LC124 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(prices,0,0,2,dp);
    }


    // buy sell buy sell there is no other pattern other than this other way also both the logic is very clear
    public int recurMemo(int[] prices,int idx,int transactions,int k,int[][] dp){
        if(transactions==2*k || idx==prices.length) return 0;
        if(dp[idx][transactions]!=-1) return dp[idx][transactions];
        int profit = 0;
        if(transactions%2==0){
            int toBuy = -prices[idx] + recurMemo(prices,idx+1,transactions+1,k,dp);
            int noBuy = recurMemo(prices,idx+1,transactions,k,dp);
            profit = Math.max(toBuy,noBuy);
        }else{
            int toSell = prices[idx]+ recurMemo(prices,idx+1,transactions+1,k,dp);
            int noSell = recurMemo(prices,idx+1,transactions,k,dp);
            profit = Math.max(toSell,noSell);
        }
        return dp[idx][transactions] = profit;
    }

}
