package LeetCode.Graph;
/*
 @author Myvin Barboza
 31/05/20 8:50 AM 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC886PossibleBipartition {

    static boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Set<Integer>> g =new HashMap<>();
        for(int d[]:dislikes){
            int a=d[0];
            int b=d[1];
            g.putIfAbsent(a,new HashSet<>());
            g.putIfAbsent(b,new HashSet<>());
            g.get(a).add(b);
            g.get(b).add(a);
        }
        int colors[]=new int[N+1];
        for(int i=1;i<=N;i++){
            if(colors[i]==0 && !dfs(colors,1,i,g)) return false;
        }
        return true;
    }

    static boolean dfs(int colors[],int color,int node,Map<Integer,Set<Integer>> g){
        if(colors[node]!=0){
            return colors[node]==color;
        }
        colors[node]=color;

        if(g.get(node)==null) return true;
        for(int next:g.get(node)){
            if(!dfs(colors,-color,next,g)) return false;
        }

        return true;

    }


    public static void main(String[] args) {
        int a[][] = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(5, a));
    }
}