package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC322 {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
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
        // System.out.println(Arrays.toString(dp));
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
