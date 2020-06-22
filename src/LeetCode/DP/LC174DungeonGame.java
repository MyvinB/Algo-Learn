package LeetCode.DP;/*
 @author Myvin Barboza
 21/06/20 5:36 PM 
 */

import java.util.Arrays;

public class LC174DungeonGame {


    static int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int dp[][]=new int[m+1][n+1];
        for (int i[]:dp) {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;

        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                ///supppse we encounter a positive value in the matrix it will get negative and then the min will be one
                //if we do noy encounter a positive value a negative one it will get positive also accounting for the current value
                //id the total is negative ie in a whole the health is positive the max becoems one cause we do not need more health than that.
                ///
                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];

    }



    public static void main(String[] args) {
        int a[][]={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int ao[][]={{0}};
        System.out.println(calculateMinimumHP(a));
    }
}
