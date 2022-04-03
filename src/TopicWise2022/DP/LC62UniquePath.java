package TopicWise2022.DP;

/**
 * @author mmichaelbarboza
 * on 6:53 AM 4/3/2022
 * Time Taken:
 */
public class LC62UniquePath {
    //Top down dp using 2d array
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathSingle(int m, int n) {
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] = dp[j] +dp[j-1];
            }
        }

        return dp[n-1];
    }


}
