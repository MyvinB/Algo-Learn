package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 12:38 AM 4/23/2022
 * Time Taken:
 */
public class LC790DominoAndTrominoTiling {

    public static void main(String[] args) {

    }
    //Simple math formula need to understand logic
    public int numTilings(int n) {
        int mod = 1000000007;
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = ((2*dp[i-1])%mod + dp[i-3])%mod;
        }
        return dp[n];
    }
}
