package LeetCodeChallenge.JAN2022;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 9:28 AM 1/6/2022
 */
public class LC1094 {
    public static void main(String[] args) {
        int[][] t = {{2,1,5},{3,3,7}};
        int c = 5;
        System.out.println(carPoolingSoln1(t,4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] trip :trips){
            while(!pq.isEmpty() && pq.peek()[2]<=trip[1]){
                capacity += pq.poll()[0];
            }
            pq.offer(trip);
            capacity -= trip[0];
            if(capacity<0) return false;
        }
        return true;
    }

    public static boolean carPoolingSoln1(int[][] trips, int capacity) {
       int[] stops = new int[1001];
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       for(int[] trip:trips){
           stops[trip[1]] += trip[0];
           stops[trip[2]] -=trip[0];
           min = Math.min(min,trip[1]);
           max = Math.max(max,trip[2]);
       }
       for(int i=min;i<=max;i++){
           capacity -=stops[i];
           if(capacity<0) return false;
       }
       return true;
    }
}
