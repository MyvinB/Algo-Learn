package practise;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 6:05 PM 12/1/2021
 */
public class LC973 {

    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p2[0]*p2[0]+p2[1]*p2[1] - p1[0]*p1[0]-p1[1]*p1[1]);
        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }
        return res;


    }
}
