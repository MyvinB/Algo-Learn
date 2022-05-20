package LeetCodeChallenge.MAY2022;

import java.util.LinkedList;
import java.util.Queue;

public class LC329 {

    public static void main(String[] args) {

    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

//Longest Increasing Path in a matrix Typo
    public int longestIncreasingPathTopo(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] inDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dir) {
                    int x = d[0] + i;
                    int y = d[1] + j;
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    //since we have this check even we go back to the lower element it will not go forward no need of viosited
                    if (matrix[x][y] > matrix[i][j]) {
                        inDegree[x][y]++;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inDegree[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int level = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-->0){
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                for (int[] d : dir) {
                    int x = d[0] + i;
                    int y = d[1] + j;
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (matrix[x][y] > matrix[i][j]) {
                        inDegree[x][y]--;
                        if(inDegree[x][y]==0) queue.offer(new int[]{x,y});
                    }
                }
            }
            level++;
        }
        return level;
    }
// Longest Increasing Path DFS -> cache values ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[m][n];
        int len = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                len = Math.max(dfs(matrix,dp,i,j),len);
            }
        }
        return len;
    }

    private int dfs(int[][] matrix,int[][] dp, int i, int j){
        int m = matrix.length,n = matrix[0].length;
        if(dp[i][j]!=0) return dp[i][j];
        int len = 1;
        for(int[] d:dir){
            int x = d[0] + i;
            int y = d[1] + j;
            if(x<0 || y<0 || x>=m || y>=n) continue;
            if(matrix[x][y]>matrix[i][j]){
                len = Math.max(1+ dfs(matrix,dp,x,y),len);
            }
        }
        dp[i][j] = len;
        return len;
    }
}
