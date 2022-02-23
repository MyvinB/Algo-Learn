package Company.MorganStanley;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:44 AM 2/22/2022
 * Time Taken:
 */
public class LC322 {

    public static void main(String[] args) {

        //https://www.youtube.com/watch?v=H9bfqozjoqs
        System.out.println(coinChange(new int[]{1,2,5},11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        //Bottom up case we know
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    //we have a positive val means posibility to compute
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount]!=amount?dp[amount]:-1;
    }

}
