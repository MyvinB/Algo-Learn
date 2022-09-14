package LeetCodeChallenge.Sep2022.DpPractise.Stock;

public class LC714 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        return recurMemo(prices,0,1,fee);
    }
    //To easy to even write dp overconfidence!!!
    public int recurMemo(int[] prices,int idx,int buy,int fee){
        if(idx==prices.length) return 0;
        int profit = 0;
        if(buy==1){
            int toBuy = -prices[idx] + recurMemo(prices,idx+1,0,fee);
            int noBuy = recurMemo(prices,idx+1,1,fee);
            profit = Math.max(toBuy,noBuy);
        }else{
           int toSell = prices[idx] - fee + recurMemo(prices,idx+1,1,fee);
           int noSell = recurMemo(prices,idx+1,0,fee);
           profit = Math.max(toSell,noSell);
        }
        return profit;
    }


    public int tabulation(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy] = Math.max(-prices[i] +dp[i+1][0],dp[i+1][1]);
                }else{
                    dp[i][buy] = Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }



}
