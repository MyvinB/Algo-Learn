package LeetCode.Graph;/*
 @author Myvin Barboza
 24/07/20 4:10 PM 
 */

import java.util.*;

public class LC797AllPathsFromSourcetoTarget {

    public static void main(String[] args) {
        int[][] graph={{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
    }
    //bfs is slower

    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<List<Integer>> queue=new LinkedList<>();
        List<Integer> pathTemp=new ArrayList<>();
        pathTemp.add(0);
        queue.offer(pathTemp);

        while(!queue.isEmpty()){
            List<Integer> path=queue.poll();
            int lastNode=path.get(path.size()-1);
            if(lastNode==graph.length-1){
                list.add(new ArrayList<>(path));
            }

            for(int a:graph[lastNode]){
                System.out.println(a);
                path.add(a);
                queue.offer(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
        }
        return list;

    }


    ///dfs
    static List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,list,path);
        return list;

    }

    static void dfs(int[][] graph,int node,List<List<Integer>> list,List<Integer> path){

        //terminal
        if(node==graph.length-1){
            list.add(new ArrayList<>(path));
        }
        int ar[]=graph[node];

        for(int a:ar){
            path.add(a);
            dfs(graph,a,list,path);
            path.remove(path.size()-1);
        }


    }

}
