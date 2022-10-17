package LeetCodeChallenge.Oct2022.Recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LC1345 {

    public static void main(String[] args) {

    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],v->new LinkedList<>()).add(i);
        }
        boolean[] vis = new boolean[n];
        queue.offer(0);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int idx = queue.poll();
                if(idx==n-1) return level;
                if(idx+1<n && !vis[idx+1]) queue.offer(idx+1);
                if(idx-1>=0 && !vis[idx-1]) queue.offer(idx-1);
                if(map.containsKey(arr[idx])){
                    Queue<Integer> temp = map.get(arr[idx]);
                    while(!temp.isEmpty()) queue.offer(temp.poll());
                }
                vis[idx] = true;
            }
            level++;
        }
        return level;
    }
}
