package LeetCodeChallenge.Aug2022.DpPractise;

public class MinimumPathSum {
    public static void main(String[] args) {
       int[][] t = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(t));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
//        return recurMemo(grid,m-1,n-1,new int[m][n]);
        return spaceOpti(grid,m,n);
    }


    public static int spaceOpti(int[][] grid,int m,int n){
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[j] = grid[i][j];
                else{
                    int up = (int)Math.pow(10,9);
                    int left = (int)Math.pow(10,9);
                    if(i>0) up = dp[j];
                    if(j>0) left = dp[j-1];
                    dp[j] = grid[i][j] +Math.min(up,left);
                }
            }
        }
        return dp[n-1];
    }

    public static int recurMemo(int[][] grid,int i,int j,int[][] dp){
        //Base case
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        if(dp[i][j]!=0) return dp[i][j];
        int left = grid[i][j] +recurMemo(grid,i,j-1,dp);
        int up = grid[i][j] +recurMemo(grid,i-1,j,dp);
        return dp[i][j]=Math.min(left,up);
    }


    public static int recur(int[][] grid,int i,int j){
        //Base case
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        int left = grid[i][j] +recur(grid,i,j-1);
        int up = grid[i][j] +recur(grid,i-1,j);
        return Math.min(left,up);
    }
}
