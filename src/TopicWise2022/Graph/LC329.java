package TopicWise2022.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 5:46 AM 3/26/2022
 * Time Taken:
 */
public class LC329 {

    public static void main(String[] args) {

    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
///-------------------------------------------------------------------------------------------------------------------Topological Sort Khan algo------------------------------------------------------------------

    public int longestIncreasingPathTopo(int[][] matrix) {
        if(matrix.length==0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] inDegree = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int[] d:dir){
                    int x = d[0]+i;
                    int y = d[1]+j;
                    if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length) continue;
                    if(matrix[x][y]>matrix[i][j]){
                        inDegree[x][y]++;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(inDegree[i][j] == 0) queue.add(new int[]{i,j});
            }
        }
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] t = queue.poll();
                for(int[] d:dir){
                    int x = t[0]+d[0];
                    int y = t[1]+d[1];
                    if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length) continue;
                    if(matrix[x][y]>matrix[t[0]][t[1]]){
                        inDegree[x][y]--;
                        if(inDegree[x][y]==0) queue.add(new int[]{x,y});
                    }

                }
            }
            level++;
        }
        return level;
    }




///-------------------------------------------------------------------------------------------------------------------DFS AND MEMO------------------------------------------------------------------

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int len = dfs(matrix,i,j,dp);
                max = Math.max(len,max);
            }
        }
        return max;

    }

    public int dfs(int[][] matrix,int i,int j,int[][] dp){
        if(dp[i][j]!=0) return dp[i][j];
        int max = 1;
        for(int[] d:dir){
            int x = i+d[0];
            int y = j+d[1];
            if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length) continue;
            if(matrix[x][y]>matrix[i][j]){
                int len = 1+ dfs(matrix,x,y,dp);
                max = Math.max(len,max);
            }
        }
        dp[i][j] = max;
        return max;
    }
}
