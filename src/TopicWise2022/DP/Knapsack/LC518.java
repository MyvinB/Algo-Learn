package TopicWise2022.DP.Knapsack;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 10:03 AM 3/28/2022
 * Time Taken:
 */
public class LC518 {

    public static void main(String[] args) {
        change(5,new int[]{1,2,5});
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1;i<=coins.length;i++){
            //If the amount is the value of the coin there is only one way we can directly choose it
            dp[i][0]= 1;
            for(int j=1;j<=amount;j++){
                //pick up the possibility excluding the coin and adding to result
                dp[i][j] += dp[i-1][j];
                //if the amount - coins is greater than zero then there is possibility to include the coin
                if(j-coins[i-1]>=0) dp[i][j]+= dp[i][j-coins[i-1]];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount];
    }
}
