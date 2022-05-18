package LeetCodeChallenge.MAY2022;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1192 {

    public static void main(String[] args) {

    }
    //Targans Algo
    /*
    * Strongs connected components ->https://www.youtube.com/watch?v=ZeDNSeilf-Y
    * Find bridges ->https://www.youtube.com/watch?v=Rhxs4k6DyMM
    * Understanding to this question -> https://www.youtube.com/watch?v=HsBefuOqkd4
    * */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        //Using adjList
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc,-1);
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        //Create adj List
        for(int i=0;i<connections.size();i++){
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 0;i< n;i++){
            if(disc[i]==-1){
                dfs(i,low,disc,graph,res,i);
            }
        }
        return res;
    }
    //Time when each vertex is discovered
    int time = 0;

    private void dfs(int u,int[] low,int[] disc,List<Integer>[] graph,List<List<Integer>> res, int pre){
        disc[u] = low[u] = ++time;
        for(int j=0; j< graph[u].size();j++){
            int v = graph[u].get(j);
            if(v==pre){
                continue; //direct parents are ignored only looking for backedge
            }
            if(disc[v] == -1){
                dfs(v,low,disc,graph,res,u);
                //Have we found a backedge we need to check and update parent nodes
                low[u] = Math.min(low[u],low[v]);
                //If that is the case no backedge is found and means if we break this link{u->v} there is no other way u and v can connect
                if(low[v]>disc[u]){
                    res.add(Arrays.asList(u,v));
                }
            }
            else {
                //We now found a backedge and need to update the low of the current element
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }

}
