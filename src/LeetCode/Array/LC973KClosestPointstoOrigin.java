package LeetCode.Array;
/*
 @author Myvin Barboza
 30/05/20 7:09 PM 
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC973KClosestPointstoOrigin {

    static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((c,d)->(c[0]-d[0]));

        for (int i = 0; i <points.length ; i++) {
            int c[]={ points[i][0]*points[i][0]+points[i][1]*points[i][1],points[i][0],points[i][1]};
            pq.add(c);
        }
        int i=0;
        int a[][]=new int[K][2];
        while(K--!=0){
            int u[]=pq.poll();
            a[i][0]=u[1];
            a[i][1]=u[2];


            i++;
        }
        return a;
    }


    public static void main(String[] args) {
        int a[][] = {{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(kClosest(a,2)));
    }

}