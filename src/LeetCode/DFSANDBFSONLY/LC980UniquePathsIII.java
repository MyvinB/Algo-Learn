package LeetCode.DFSANDBFSONLY;

public class LC980UniquePathsIII {

    static int uniquePaths(int[][] grid) {
        int zero=0;
        int sx=0,sy=0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
             if(grid[i][j]==0){
                 zero++;
             }
             else if(grid[i][j]==1){
                 sx=i;sy=j;
             }
            }
        }

        return dfs(grid,sx,sy,zero);

    }
    final static int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static int dfs(int grid[][],int x,int y,int zero){

        //boundary
        if(x<0 ||y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==-1) return 0;

        //final

        if(grid[x][y]==2){
            return zero==-1?1:0;
        }


        //iteration
        zero--;
        grid[x][y]=-1;
        int totalPath=0;
        for(int d[]:dir){
            totalPath+=dfs(grid,x+d[0],y+d[1],zero);
        }
        grid[x][y]=0;
        zero++;

        return totalPath;

    }

    public static void main(String[] args) {
        int[][] grid ={{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePaths(grid));
    }
}
