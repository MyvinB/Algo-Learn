package LeetCodeChallenge.MAY2022;

import java.util.Arrays;

public class LC322CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins,11));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                int balance = i-coins[j];
                if(balance>=0){
                    dp[i] = Math.min(dp[i],1+dp[balance]);
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        if(dp[amount]==amount+1) return -1;
        return dp[amount];
    }
}
