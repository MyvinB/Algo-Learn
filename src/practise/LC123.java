package practise;

public class LC123 {

    public static void main(String[] args) {
        int a[] = new int[]{2,5,7,1,4,3,1,3};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        //https://www.youtube.com/watch?v=oDhu5uGq_ic
        if(prices.length==0) return 0;
        int n=prices.length;
        //no of transactions
        int k=2;
        int dp[][]=new int[k+1][n];
        //price[j]-price[m]+dp[i-1][j]
        for(int i=1;i<dp.length;i++){
            int maxDiff= -prices[0];
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]= Math.max(dp[i][j-1],prices[j]+maxDiff);
                //storing previous value of tran
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }

        return dp[k][n-1];


    }
}
