package Contest.Upsolve;

public class LC2267 {

    public static void main(String[] args) {

    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean [][][]memo = new Boolean[m][n][m+n];
       return  dfs(grid,0,0,0,memo);
    }

    public boolean dfs(char[][] grid,int i,int j,int bal,Boolean[][][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || bal<0) return false;
        if(visited[i][j][bal]!=null) return visited[i][j][bal];
        int updateBal = bal + (grid[i][j]=='('?1:-1);
        if(i==m-1 && j==n-1 && updateBal == 0) return true;
        boolean valid = dfs(grid,i+1,j,updateBal,visited) || dfs(grid,i,j+1,updateBal,visited);
        visited[i][j][bal] = valid;
        return valid;
    }
}
