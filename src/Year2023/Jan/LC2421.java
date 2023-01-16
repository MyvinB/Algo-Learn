package Year2023.Jan;

import java.util.*;

public class LC2421 {

    int[] parent ,rank;

//Path compression algo basically makes everything link to the parent on the fly
    int findParent(int node){
        if(node==parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    void union(int u,int v){
        v = findParent(u);
        u = findParent(v);
        if(v==u) return;
        if(rank[v]<rank[u]){
            parent[v] = u;
        }else if (rank[u]<rank[v]){
            parent[u]=v;
        }else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<List<Integer>> adjList = new ArrayList<>();
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
            parent[i] = i;
        }
        for(int[] a:edges){
            int u = a[0];
            int v = a[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int value = vals[i];
            if(!map.containsKey(value)) map.put(value,new ArrayList<>());
            map.get(value).add(i);
        }
        int result = n;
        boolean[] active = new boolean[n];
        for(int k:map.keySet()){
            List<Integer> list = map.get(k);
            for(int i=0;i<list.size();i++){
                int val = list.get(i);
                for(int child:adjList.get(val)){
                    if(active[child]) union(val,child);
                }
                active[val] = true;
            }
            List<Integer> parents = new ArrayList<>();
            for(int i: list){
                int parent = findParent(i);
                parents.add(parent);
            }
            Collections.sort(parents);
            for(int i=0;i<list.size();i++){
                int count =0;
                int cur = list.get(i);
                while(i<list.size() &&cur == list.get(i)){
                    i++;
                    count++;
                }
                i--;
                int formula = (count *(count-1)/2);
                result+= formula;
            }
        }

        return result;
    }
}
