package LeetCode.DP;
/*
 @author Myvin Barboza
 07/06/20 12:57 PM 
 */

public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
            for(int j=0;j<=amount;j++){
                int currentCoinVal=coins[i-1];
                int withOutCoin=dp[i-1][j];
                int withCoin=currentCoinVal<=j?dp[i][j-currentCoinVal]:0;
                dp[i][j]=withCoin+withOutCoin;
            }
        }
        return dp[coins.length+1][amount+1];
    }

    public static void main(String[] args) {

    }
}