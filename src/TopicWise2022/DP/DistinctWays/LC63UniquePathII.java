package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 8:03 AM 4/14/2022
 * Time Taken:
 */
public class LC63UniquePathII {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0},{1}};
        System.out.println(uniquePathsWithObstacles(t));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            dp[i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[j] = 0;
                else{
                    if(j==0) continue;
                    else dp[j] = dp[j]+dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
