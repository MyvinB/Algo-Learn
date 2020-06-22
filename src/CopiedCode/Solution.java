package CopiedCode;/*
 @author Myvin Barboza
 21/06/20 3:56 PM 
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

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

                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }
        return dp[0][0];

    }



    public static void main(String[] args) {
        int a[][]={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int ao[][]={{0}};
        System.out.println(calculateMinimumHP(a));
    }
}
