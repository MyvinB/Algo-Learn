package LeetCodeChallenge.Oct2022.Graph;

import java.util.ArrayList;
import java.util.List;

public class LC547 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        //Convert matrix to adj list
        List<List<Integer>> adjList = new ArrayList<>();
        int m = isConnected.length;
        for(int i=0;i<m;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                }
            }
        }

        //DFS
        int count = 0;
        int[] vis = new int[m];
        for(int i=0;i<m;i++){
            if(vis[i]==0){
                count++;
                vis[i] = 1;
                dfs(adjList,i,vis);
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList,int idx,int[] vis){

        List<Integer> tempList= adjList.get(idx);
        for(int i=0;i<tempList.size();i++){
            int index = tempList.get(i);
            if(vis[index]!=1){
                vis[index] = 1;
                dfs(adjList, index,vis);
            }
        }
    }

}
