package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 3:40 PM 1/22/2022
 */
public class LC1510 {
    public static void main(String[] args) {
        System.out.println(winnerSquareGame(7));
    }

    public static boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for(int i=1;i<=n;i++){
            for(int k=1;k*k<=i;k++){
                if(!dp[i-k*k]){
                    dp[i]= true;
                    break;
                }

            }
        }
        return dp[n];
    }
}
