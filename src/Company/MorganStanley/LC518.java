package Company.MorganStanley;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 8:36 AM 2/23/2022
 * Time Taken:
 */
public class LC518 {

    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1;i<=coins.length;i++){
            dp[i][0] = 1;
            for(int j=1;j<=amount;j++){

                //Not taking current coin and looking previous coin
                dp[i][j] += dp[i-1][j];
                //taking coin intt consideration if value > 0
                if(j-coins[i-1]>=0) dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount];
    }
}
