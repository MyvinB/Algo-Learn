package LeetCodeChallenge.Sep2022.GraphPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSofAnAcyclicGraph {

    public static void main(String[] args) {


    }
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj){
        int size = adj.size();
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean vis[] = new boolean[size+1];
        for(int i =0;i<=size;i++){
            if(!vis[i]) dfs(i,vis,adj,storeDfs);
        }
        return storeDfs;
    }

    public static void dfs(int node , boolean vis[], ArrayList<ArrayList<Integer>> adj, List<Integer> dfsStore){
        dfsStore.add(node);
        vis[node] = true;
        for(int i:adj.get(node)){
            if(vis[node]){
                dfs(i,vis,adj,dfsStore);
            }
        }
    }
}
