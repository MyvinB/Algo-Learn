package practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 8:19 AM 11/30/2021
 */
public class LC1730 {

    public static void main(String[] args) {

    }

    public int getFood(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int step = 0;
        int[] start = findStart(grid);
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        q.add(start);
        boolean[][] visited = new boolean[m][n];
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                for(int[] d:dir){
                    int newX= x+ d[0];
                    int newY = y+d[1];
                    if(isValid(grid,newX,newY) && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX,newY});
                    }
                }

            }
            step++;
        }
        return step;
    }

    public int[] findStart(char[][] grid){
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '*') return new int[]{i,j};
            }
        }
        throw new RuntimeException();
    }

    public boolean isValid(char[][] grid,int i,int j){
        if(i<0 ||j<0 ||i>=grid.length ||j>=grid[0].length || grid[i][j]=='X' ) return false;
        return true;
    }
}
