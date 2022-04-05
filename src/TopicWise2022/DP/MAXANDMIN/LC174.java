package TopicWise2022.DP.MAXANDMIN;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:31 PM 4/5/2022
 * Time Taken:
 */
public class LC174 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        calculateMinimumHP(t);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        //Last base case
        dp[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);
        //Calculating the single choice options
        for(int i = m-2;i>=0;i--){
            int cur = dungeon[i][n-1];
            int prev = dp[i+1][n-1];
            //if value is less than zero that means we have more power than rew make it one there cause that's all we need to live
            dp[i][n-1] = Math.max(prev-cur,1);
        }

        for(int j=n-2;j>=0;j--){
            int cur = dungeon[m-1][j];
            int prev = dp[m-1][j+1];
            dp[m-1][j] = Math.max(prev-cur,1);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = Math.min(down,right) - dungeon[i][j];
                dp[i][j] = Math.max(dp[i][j],1);
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];

    }


}
