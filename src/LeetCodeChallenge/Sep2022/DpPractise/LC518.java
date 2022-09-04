package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC518 {

    public static void main(String[] args) {

    }
    //Here its no of way so think a final result set is one set
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp= new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                int balance = j-coins[i];
                if(balance>=0)
                    dp[j] += dp[balance];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
