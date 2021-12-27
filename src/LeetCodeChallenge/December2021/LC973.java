package LeetCodeChallenge.December2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 2:06 PM 12/27/2021
 */
public class LC973 {

    public static void main(String[] args) {
        int[][] test = {{1,3},{-2,2}};
        System.out.println(Arrays.deepToString(kClosest(test,1)));

    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]);
        });

        for(int[] ar:points){
            pq.add(ar);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int r=0;
        while(k-->0){
            res[r++] = pq.poll();
        }
        return res;
    }
}
