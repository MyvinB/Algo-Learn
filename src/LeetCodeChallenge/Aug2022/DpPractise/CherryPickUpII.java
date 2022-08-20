package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;

public class CherryPickUpII {

    public static void main(String[] args) {

    }

    public int cherryPickup(int[][] grid) {
        int i = grid.length;
        int j2 = grid[0].length;
        int[][][] dp = new int[i][j2][j2];
        for (int row1[][]: dp) {
            for (int row2[]: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return recurMemo(grid,0,0,j2-1,dp);
    }

    public int tabulation(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        //Populating the values
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2) dp[m-1][j1][j2] = grid[m-1][j1];
                else dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        //Top down

        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int maxi = Integer.MIN_VALUE;
                    for(int k=-1;k<=1;k++){
                        for(int p=-1;p<=1;p++){
                            int ans;
                            if(j1==j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];
                            if(j1+k<0 || j1+k>=n || j2+p<0 || j2+p>=n) ans += -1e9;
                            else ans+=dp[i+1][j1+k][j2+p];

                            maxi = Math.max(maxi,ans);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0][n-1];
    }

    public int recurMemo(int[][] grid,int i,int j1,int j2,int[][][] dp){
        if(j1<0 || j2<0 ||j1>=grid[0].length || j2>=grid[0].length) return (int)Math.pow(-10,9);
        if(i==grid.length-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+ grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for(int k=-1;k<=1;k++){
            for(int p=-1;p<=1;p++){
                int ans;
                if(j1==j2)
                    ans = grid[i][j1] +recurMemo(grid,i+1,j1+k,j2+p,dp);
                else
                    ans = grid[i][j1] + grid[i][j2] + recurMemo(grid,i+1,j1+k,j2+p,dp);
                maxi = Math.max(ans,maxi);
            }
        }
        return dp[i][j1][j2] = maxi;
    }






}
