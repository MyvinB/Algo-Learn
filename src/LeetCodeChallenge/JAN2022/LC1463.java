package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 3:48 PM 1/8/2022
 */
public class LC1463 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherryPickup(a));
     }

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid,0,0,n-1,dp);
    }

    private static int dfs(int[][] grid,int r,int c1,int c2,Integer[][][] dp){
        int m = grid.length;
        int n = grid[0].length;
        //corner cases
        if(r<0 ||r>=m || c1<0 || c1>=n || c2<0 || c2>=n){
            return 0;
        }
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];

        int maxCherry = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newC1 = c1+i;
                int newC2 = c2+j;
                maxCherry = Math.max(maxCherry,dfs(grid,r+1,newC1,newC2,dp));
            }
        }
        int currentCherry=0;
        if(c1==c2){
            currentCherry = grid[r][c1];
        }
        else currentCherry = grid[r][c1]+grid[r][c2];

        return maxCherry+currentCherry;
    }
}
