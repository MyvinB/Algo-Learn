package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 10:35 AM 4/25/2022
 * Time Taken:
 */
public class LC1155NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {

    }

    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][target+1];
        //If zero there is one possible way
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                for(int t=1;t<=k;t++){
                    if(j-t<0) continue;
                    dp[i][j] = dp[i][j]%mod + dp[i-1][j-t]%mod;
                    dp[i][j] = dp[i][j]%mod;
                }

            }
        }
        return dp[n][target];
    }
}
