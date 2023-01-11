package Year2023.Jan;

import java.util.ArrayList;
import java.util.List;

public class LC1443 {

    public static void main(String[] args) {

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a:edges){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        return getTime(adjList,hasApple,0,-1);
    }


    public int getTime(List<List<Integer>> adjList,List<Boolean> hasApple,int idx,int parent){
        int total = 0;
        for(int t:adjList.get(idx)){
            if(t==parent) continue;
            total += getTime(adjList,hasApple,t,idx);
        }
        if(idx!=0 &&(total>0 || hasApple.get(idx))) total+=2;
        return total;
    }
}
