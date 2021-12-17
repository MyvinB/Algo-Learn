package LeetCodeChallenge.December2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 9:56 AM 12/17/2021
 */
public class LC310 {

    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if(n<=0){
            return res;
        }
        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }

        while(n>2){
            int size = q.size();
            n -= size;
            while (size-->0){
                int val = q.poll();
                for(int i:adjList.get(val)){
                    degree[i]--;
                    if(degree[i]==1)q.add(i);
                }
            }
        }

        res.addAll(q);
        return res;

        


    }
}
