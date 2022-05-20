package TopicWise2022.DFS;

public class LC980UniquePathIII {

    public static void main(String[] args) {

    }

    int[][] dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int res = 0,empty=1;//post decrement ie 1

    public int uniquePathsIII(int[][] grid) {
        int m= grid.length,n = grid[0].length,sx = 0,sy=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) empty++;
                else if(grid[i][j]==1){
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid,sx,sy);
        return res;
    }

    private void dfs(int[][] grid, int i, int j){
        int m= grid.length,n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n ||grid[i][j]<0) return;
        if(grid[i][j]==2 && empty==0){
            res++;
            return;
        }
        grid[i][j] = -2;
        empty--;
        for(int[] d:dir){
            int x = i + d[0];
            int y = j + d[1];
            dfs(grid,x,y);
        }
        empty++;
        grid[i][j] = 0;
    }
}
