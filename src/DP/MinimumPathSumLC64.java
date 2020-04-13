package DP;

/*
 @author Myvin Barboza
 13/04/20 7:17 AM 
 */
public class MinimumPathSumLC64 {

    static int minPathSum(int[][] grid) {
//        int i=grid.length-1;
//        int j=grid[i].length-1;
//        return recurSum(grid,i,j);
        return dpSum(grid);

    }

    ///recur time limit exceeded
    static int recurSum(int[][] grid,int i,int j){
        if(i==0 && j==0)return grid[i][j];
        if(i==0) return grid[i][j] +recurSum(grid,i,j-1);
        if(j==0) return grid[i][j] +recurSum(grid,i-1,j);


        return grid[i][j]+Math.min(recurSum(grid,i,j-1),recurSum(grid,i-1,j));

    }

    static int dpSum(int [][] grid){
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if(i==0 && j==0);
                else if(i==0 && j!=0) grid[i][j]+=grid[i][j-1];
                else if(i!=0 && j==0) grid[i][j]+=grid[i-1][j];
                else grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        int m=grid.length-1;
        int n=grid[m].length-1;
        return grid[m][n];
    }


    public static void main(String[] args) {
    int grid[][]={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}