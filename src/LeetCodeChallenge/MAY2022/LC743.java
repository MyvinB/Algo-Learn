package LeetCodeChallenge.MAY2022;

import java.util.*;

public class LC743 {

    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map = buildGraph(times);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        Set<Integer> visited = new HashSet<>();
        int totalTime = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            while(size-->0){
                int[] node = pq.poll();
                int source = node[0];
                int cost = node[1];
                if(visited.contains(source)) continue;
                visited.add(source);
                totalTime = cost;
                if(visited.size()==n){
                    return totalTime;
                }
                if(!map.containsKey(source)) continue;
                for(int[] t:map.get(source)){
                    int child = t[0];
                    int childTime = cost + t[1];
                    pq.offer(new int[]{child,childTime});
                }
            }
        }
        return -1;
    }


    private Map<Integer, List<int[]>> buildGraph(int[][] times){
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t:times){
            int s = t[0];
            int d = t[1];
            int c = t[2];
            map.putIfAbsent(s,new ArrayList<>());
            map.get(s).add(new int[]{d,c});
        }
        return map;
    }
}
