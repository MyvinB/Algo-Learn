package Company.Amazon;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 8:16 AM 3/22/2022
 * Time Taken:
 */
public class LC973 {

    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));
        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int r =0;
        while(!pq.isEmpty()){
            res[r++] = pq.poll();
        }
        return res;
    }
}
