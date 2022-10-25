package LeetCodeChallenge.Oct2022.Graph;
/*
Problem Link
https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands
*/

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberOfIslands {



    public static void main(String[] args) {

    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && grid[i][j]=='1'){
                    // System.out.println("i,"+i+"j->"+j+"Not visited");
                    count++;
                    vis[i][j] = 1;
                    bfs(grid,vis,i,j);
                }
            }
            // System.out.println(Arrays.deepToString(vis));
        }
        return count;
    }

    public void bfs(char[][] grid,int[][] vis,int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println("Size at level"+size);
            while(size-->0){
                int[] pair = queue.poll();
                int p = pair[0];
                int q = pair[1];
                // System.out.println(p+":"+q);
                for(int[] d:dir){
                    int x = p+d[0];
                    int y = q+d[1];
                    if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]=='0' || vis[x][y]==1)  continue;
                    vis[x][y] = 1;
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }

}
