package LeetCodeChallenge.MAY2022;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091 {

    public static void main(String[] args) {
        int t[][] = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(t));
    }
    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length ,n=grid[0].length;
        int visited[][] = new int[m][n];
        Integer[][] dp = new Integer[m][n];
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int path = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            path++;
            while(size-->0){
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                if(x==m-1 && y==n-1) return path;
                for(int[] d:dir){
                    int i = x + d[0];
                    int j = y + d[1];
                    if( i<0 || i>=grid.length || j<0 || j>=grid[0].length ||grid[i][j]!=0 || visited[i][j]==1) continue;
                    queue.offer(new int[]{i,j});
                    visited[i][j]= 1;
                }
                grid[x][y] = 0;
            }
        }
        return -1;
    }

}
