package LeetCodeChallenge.Nov2022.Daily;

public class LC1706 {

    public static void main(String[] args) {

    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        for(int j=0;j<n;j++){
            res[j] = dfs(grid,0,j);
        }
        return res;
    }

    public int dfs(int[][] grid,int i,int j){
        if(i==grid.length){
            return j;
        }
        if(grid[i][j]==1 && j+1<grid[0].length && grid[i][j+1]==1 ){
            return dfs(grid,i+1,j+1);
        }
        if(grid[i][j]==-1 && j-1>=0 && grid[i][j-1]==-1){
            return dfs(grid,i+1,j-1);
        }
        return -1;
    }
}
