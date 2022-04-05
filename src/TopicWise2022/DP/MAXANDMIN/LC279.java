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
        int dp[]=new int[n+1];
//        Arrays.fill(dp, );
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}
