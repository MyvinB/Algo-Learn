package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 20/12/20 8:30 AM 
 */

public class LC1463CherryPickupII {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}};
        System.out.println(cherryPickup(grid));


    }
   static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c2 = n-1;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(m,n,0,0,c2,grid,dp);

    }

    static int dfs(int row,int col,int r,int c1,int c2,int[][] grid,Integer[][][] dp){
        if(r<0 || r>=row || c1<0 || c1>=col || c2<0 || c2>=col )
            return 0;
        if(dp[r][c1][c2]!=null){
            return dp[r][c1][c2];
        }
        int maxCherries = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nc1 = c1+i;
                int nc2 = c2+j;
                maxCherries = Math.max(maxCherries,dfs(row,col,r+1,nc1,nc2,grid,dp));
            }
        }
        int curCherry=0;
        if(c1 == c2){
            curCherry = grid[r][c1];
        }else{
            curCherry = grid[r][c1]+grid[r][c2];
        }
        dp[r][c1][c2]=maxCherries+curCherry;
        return dp[r][c1][c2];
    }
}
