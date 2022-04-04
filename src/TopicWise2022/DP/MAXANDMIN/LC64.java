package TopicWise2022.DP.MAXANDMIN;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 12:21 PM 4/4/2022
 * Time Taken:
 */
public class LC64 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(t));
    }
//Top Down dp
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i< m;i++){
            for(int j= 0;j<n ;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                //if element are vertical or horizontal its only one decision which is a simple presum
                else if(i==0 && j!=0) dp[i][j] = grid[i][j]+dp[i][j-1];
                else if(i!=0 && j==0) dp[i][j] = grid[i][j]+dp[i-1][j];
                else {
                    //if element is in the middle we chose from left or right
                    int left = dp[i][j-1];
                    int up = dp[i-1][j];
                    dp[i][j] = grid[i][j] + Math.min(left,up);
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
}
