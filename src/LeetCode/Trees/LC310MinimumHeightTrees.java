package LeetCode.Trees;

import java.util.*;

public class LC310MinimumHeightTrees {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adjList = new ArrayList<>(n);
        for(int i=0;i<n;i++)
            adjList.add(new HashSet<>());
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(adjList.get(i).size()==1)leaves.add(i);
        }
        System.out.println(leaves);
        while(n>2){
            n -=leaves.size();
            List<Integer> newleaves =new ArrayList<>();
            for(int i: leaves){
                int j=adjList.get(i).iterator().next();
                adjList.get(j).remove(i);
                if(adjList.get(j).size()==1)newleaves.add(j);
            }
            leaves=newleaves;
        }

        return leaves;

    }
}
