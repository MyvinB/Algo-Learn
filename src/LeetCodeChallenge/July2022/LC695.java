package LeetCodeChallenge.July2022;

public class LC695 {

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxWays = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxWays= Math.max(areaOfIsland(grid,i,j),maxWays);
                }
            }
        }
        return maxWays;
    }

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int areaOfIsland(int[][] grid,int i,int j){
        if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length  || grid[i][j]==0 ) return 0;
        int noOfIsland = 0;
        noOfIsland= noOfIsland+1;
        for(int[] d:dir){
            int nr = d[0]+i;
            int nc = d[1]+j;
            grid[i][j] = 0;
            noOfIsland+=areaOfIsland(grid,nr,nc);
        }
        return noOfIsland;
    }
}
