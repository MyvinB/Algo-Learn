package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 7:54 AM 4/14/2022
 * Time Taken:
 */
public class LC62UniquePath {

    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // as there is only one possible movement on the top that is looking to the left
        for(int i=0;i<n;i++) dp[i] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] = dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }
}
