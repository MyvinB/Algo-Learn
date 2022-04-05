package TopicWise2022.DP.MAXANDMIN;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 10:07 PM 4/5/2022
 * Time Taken:
 */
public class LC279 {
    public static void main(String[] args) {
        System.out.println(numSquares(9));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            //Here we need if squares or not so we traverse till half 2*2<=4 when we find a case like this ie number is a perfect square which is then dp[0]+1 which is 1
            for(int j=1;j*j<=i;j++){
                // here we minus a perfect square and see the prev result see we have one perfect square say when j =2 ie 4 or j=3 ie 9 since we minus that we add one
                dp[i] = Math.min(dp[i],1 +dp[i-j*j]);
            }
        }
        return dp[n];
    }
}
