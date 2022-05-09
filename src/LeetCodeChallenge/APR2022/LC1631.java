package LeetCodeChallenge.APR2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1631 {

    public static void main(String[] args) {

    }

//    public int minimumEffortPath(int[][] heights) {
//        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//        int m = heights.length;
//        int n = heights[0].length;
//        int dist[][] = new int[m][n];
//        for(int i=0;i<m;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
//        minHeap.offer(new int[]{0,0,0}); //distance, row , col
//        dist[0][0] = 0;
//        while(!minHeap.isEmpty()){
//            int[] top = minHeap.poll();
//            int d = top[0],r = top[1],c = top[2];
//
//            if(d>dist[r][c]) continue;
//            for(int[] dr:dir){
//                int nr = r + dr[0];
//                int nc = c + dr[1];
//                if(nr>=m || nc>=n ||nr<0 || nc<0) continue;
//                int newDistance = Math.max(d,heights[nr][nc]-heights[r][c]);
//                if(dist[nr][nc]>newDistance){
//                    dist[nr][nc] = newDistance;
//                    minHeap.offer(new int[]{newDistance,nr,nc});
//                }
//            }
//        }
//    }
}
