package LeetCodeChallenge.Sep2022.DpPractise.Stock;

import javax.print.attribute.standard.Fidelity;
import java.util.Arrays;

public class LC122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(prices,0,1,dp);
    }

    public int recurMemo(int[] prices,int idx,int buy,int[][] dp){
        if(idx==prices.length) return 0;
        int profit = 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            int toBuy = -prices[idx] +recurMemo(prices,idx+1,0,dp);
            int noBuy = recurMemo(prices, idx+1,1,dp);
            profit = Integer.max(toBuy,noBuy);
        }else{
            int toSell = prices[idx]+recurMemo(prices,idx+1,1,dp);
            int noSell = recurMemo(prices,idx+1,0,dp);
            profit = Integer.max(toSell,noSell);
        }
        return profit=dp[idx][buy];
    }

    public int tabulation(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0]= dp[n][1] = 0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    int toBuy = -prices[i] + dp[i+1][0];
                    int noBuy = dp[i+1][1];
                    dp[i][buy] = Integer.max(toBuy,noBuy);
                }else{
                    int toSell = prices[i]+dp[i+1][1];
                    int noSell = dp[i+1][0];
                    dp[i][buy] = Integer.max(toSell,noSell);
                }
            }
        }
        return dp[0][1];
    }
}
