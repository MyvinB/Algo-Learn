package LeetCode.DP;/*
 @author Myvin Barboza
 22/07/20 8:38 AM
 help:https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean
 */

import java.util.ArrayList;
import java.util.List;

public class LC417PacificAtlanticWaterFlow {

        //exact same concept no difference done with queue
    //just store the points poll them and keep offering their directions into the queue
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0)
            return list;


        int m=matrix.length,n=matrix[0].length;
        boolean pacific[][]=new boolean[m][n];
        boolean atlantic[][]=new boolean[m][n];
        //row wise flooding form both the passific and altlantic into the mattrix
        for(int i=0;i<m;i++){
            dfs(matrix,pacific,Integer.MIN_VALUE,i,0);
            dfs(matrix,atlantic,Integer.MIN_VALUE,i,n-1);
        }
        //column wise
        for(int i=0;i<n;i++){
            dfs(matrix,pacific,Integer.MIN_VALUE,0,i);
            dfs(matrix,atlantic,Integer.MIN_VALUE,m-1,i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }


        return list;



    }
    static int dp[][]={{0,1},{0,-1},{1,0},{-1,0}};


    static void dfs(int[][] matrix,boolean visited[][],int height,int i,int j){
        int m=matrix.length,n=matrix[0].length;
        if(i<0 || j<0 || i>=m ||j>=n || matrix[i][j]<height || visited[i][j])
            return;
        visited[i][j]=true;
        for(int a[]:dp){
            dfs(matrix,visited,matrix[i][j],i+a[0],j+a[1]);
        }

    }

    public static void main(String[] args) {

    }


}
