package LeetCode.DP;/*
 @author Myvin Barboza
 07/07/20 4:55 PM 
 */

public class LC463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int val=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return calPeri(grid,i,j);

                }
            }
        }
        return val;

    }
    static int calPeri(int grid[][],int i,int j){
        //terminal conditions
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]==0) return 1;
        if(grid[i][j]==-1) return 0;
        grid[i][j]=-1;

        return calPeri(grid,i+1,j)+calPeri(grid,i-1,j)+calPeri(grid,i,j+1)+calPeri(grid,i,j-1);
    }
}
