package LeetCodeChallenge.Sep2022.DpPractise.Stock;

import java.util.Arrays;

public class LC123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] a:dp)
            for(int[] b:a)Arrays.fill(b,-1);
        return recurMemo(prices,0,1,2,dp);
    }

    public int recurMemo(int[] prices,int idx,int buy,int cap,int[][][] dp){
        if(idx==prices.length) return 0;
        if(cap==0) return 0;
        int profit = 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            int toBuy = -prices[idx] + recurMemo(prices,idx+1,0,cap,dp);
            int notbuy = recurMemo(prices,idx+1,1,cap,dp);
            profit = Math.max(toBuy,notbuy);
        }else{
            int toSell = prices[idx] + recurMemo(prices,idx+1,1,cap-1,dp);
            int noSell = recurMemo(prices,idx+1,0,cap,dp);
            profit = Math.max(toSell,noSell);
        }
        return dp[idx][buy][cap] = profit;
    }

    public int tabulation(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        //Base cases are all zero ignore

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        int toBuy = -prices[i] + dp[i+1][0][cap];
                        int notbuy = dp[i+1][1][cap];
                        dp[i][buy][cap] = Math.max(toBuy,notbuy);
                    }else{
                        int toSell = prices[i] + dp[i+1][1][cap-1];
                        int noSell = dp[i+1][0][cap];
                        dp[i][buy][cap] = Math.max(toSell,noSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    public int spaceOptimisation(int[] prices){
        int n = prices.length;
        int[][] dpAfter = new int[2][3];
        int[][] dpCur = new int[2][3];
        //Base cases are all zero ignore

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        int toBuy = -prices[i] + dpAfter[0][cap];
                        int notbuy = dpAfter[1][cap];
                        dpCur[buy][cap] = Math.max(toBuy,notbuy);
                    }else{
                        int toSell = prices[i] + dpAfter[1][cap-1];
                        int noSell = dpAfter[0][cap];
                        dpCur[buy][cap] = Math.max(toSell,noSell);
                    }
                }
            }
            dpAfter = dpCur;
        }
        return dpAfter[1][2];
    }
}
