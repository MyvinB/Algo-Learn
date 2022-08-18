package LeetCodeChallenge.Aug2022.DpPractise;

public class UniquePathsWIthObstacle {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return spaceOptimisation(m,n,obstacleGrid);
    }

    public int spaceOptimisation(int m,int n,int[][] oG){
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(oG[i][j]==1) dp[j] = 0;
                else if(i==0 && j==0) dp[j]=1;
                else {

                    int left = 0;
                    int up = 0;
                    if(j>0)left = dp[j-1];
                    if(i>0)up = dp[j];
                    dp[j] = left+up;
                }
            }
        }
        return dp[n-1];
    }
}
