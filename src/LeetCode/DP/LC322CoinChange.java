package LeetCode.DP;
/*
 @author Myvin Barboza
 08/06/20 6:55 AM 
 */

import java.util.Arrays;

public class LC322CoinChange {

    static int coinChange(int[] coins, int amount) {
    int dp[]=new int[amount+1];
        // Initialize the dp table
        Arrays.fill(dp,amount+1);
         /*
      The answer to making change with minimum coins for 0
      will always be 0 coins no matter what the coins we are
      given are
    */
        dp[0]=0;
        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                // If it is less than or equal to the sub problem amount
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

         /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then
      return -1.
      Otherwise, dp[amount] holds the answer
    */
        return dp[amount]>amount?-1:dp[amount];
    }


    public static void main(String[] args) {
    int a[]={2},amount=3;
        System.out.println(coinChange(a,amount));
    }
}