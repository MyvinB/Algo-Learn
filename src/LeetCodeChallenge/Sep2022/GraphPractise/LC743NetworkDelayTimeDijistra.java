package LeetCodeChallenge.Sep2022.GraphPractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class LC743NetworkDelayTimeDijistra {

    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = buildGraph(times);
        //Lower cost will be taken first according to the sorting algo
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        //Visited hashset to see if element is not visited before
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int size = pq.size();
            while(size-->0){
                int[] node = pq.poll();
                int s = node[0];
                int c = node[1];
                if(visited.contains(s)) continue;
                visited.add(s);
                if(visited.size()==n) return c;
                if(!map.containsKey(s)) continue;
                for(int[] t:map.get(s)){
                    int childDestination = t[0];
                    //Add the prev cost of traversal to the new child nodes
                    int childCost = c+t[1];
                    pq.offer(new int[]{childDestination,childCost});
                }
            }
        }
        return -1;

    }


    public HashMap<Integer, List<int[]>> buildGraph(int[][] times){
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t:times){
            int s = t[0];
            int d = t[1];
            int c = t[2];
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(new int[]{d,c});
        }
        return map;
    }
}
