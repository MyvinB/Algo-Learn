package Year2023.Jan;

import java.util.*;

public class LC787 {

    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] f:flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0});
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int stops = 0;
        while(!queue.isEmpty() && stops<=k){
            int size = queue.size();
            while(size-->0){
                int[] t = queue.poll();
                int prevCost = t[1];
                List<int[]> childNodes = adj.get(t[0]);

                for(int[] c:childNodes){
                    int child = c[0];
                    int costToReachChild = c[1];
                    if(prevCost+costToReachChild>=dist[child]) continue; //if we have something smaller why even consider somethign bigger
                    dist[child] = prevCost+costToReachChild;
                    queue.offer(new int[]{c[0],dist[child]});
                }
            }
            stops++;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

    }
}
