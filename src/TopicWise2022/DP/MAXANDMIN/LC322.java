package TopicWise2022.DP.MAXANDMIN;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 10:28 PM 4/5/2022
 * Time Taken:
 */
public class  LC322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int balance = i- coins[j];
                if(balance>=0){
                    dp[i] = Math.min(dp[i],1+dp[balance]);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
