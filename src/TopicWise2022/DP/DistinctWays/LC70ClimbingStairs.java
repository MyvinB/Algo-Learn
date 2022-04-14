package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 8:32 AM 4/14/2022
 * Time Taken:
 */
public class LC70ClimbingStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n>=1){
            dp[1] = 1;
        }
        if(n>=2){
            dp[2] = 2;
        }
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
