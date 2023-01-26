package Year2023.Jan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC2359 {

    public static void main(String[] args) {

    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);

        int minNode = -1;
        int minSteps = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(dist1));
        System.out.println(Arrays.toString(dist2));
        for(int i=0;i<n;i++){
            int max = Math.max(dist1[i],dist2[i]);
            if(minSteps>max){
                minSteps = max;
                minNode = i;
            }
        }
        return minNode;
    }

    public void bfs(int[] edges,int node, int[] dist){
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[edges.length];
        queue.add(node);
        vis[node] = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int v = edges[cur];
            if(v!=-1 && vis[v]==0){
                vis[v] = 1;
                dist[v] = 1+ dist[cur];
                queue.add(v);
            }
        }
    }
}

