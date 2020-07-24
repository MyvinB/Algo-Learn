package LeetCode.Graph;/*
 @author Myvin Barboza
 24/07/20 5:20 PM 
 */

import java.util.LinkedList;
import java.util.Queue;

public class LC785IsGraphBipartite {
    public static void main(String[] args) {

    }
    //bfs is slower
    public boolean isBipartite(int[][] graph) {
        int colors[]=new int[graph.length];
        for(int i=0;i<colors.length;i++){
            if(colors[i]==0){
                Queue<Integer> queue=new LinkedList<>();
                queue.offer(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    int cur=queue.poll();
                    for(int a:graph[cur]){
                        if(colors[a]==0){
                            colors[a]=-colors[cur];
                            queue.offer(a);
                        }
                        else if(colors[a]==colors[cur]) return false;
                    }

                }
            }
        }
        return true;
    }

    //dfs
    public boolean isBipartiteDfs(int[][] graph) {
        int colors[]=new int[graph.length];
        for(int i=0;i<colors.length;i++){
            if(colors[i]==0 && !dfs(graph,1,colors,i)) return false;
        }
        return true;
    }

    static boolean dfs(int[][] graph,int color,int colors[],int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }
        colors[node]=color;
        for(int a:graph[node]){
            if(!dfs(graph,-color,colors,a)) return false;

        }
        return true;
    }


}
