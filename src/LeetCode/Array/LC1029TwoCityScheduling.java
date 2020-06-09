package LeetCode.Array;
/*
 @author Myvin Barboza
 03/06/20 2:53 PM 
 */

import java.util.PriorityQueue;

public class LC1029TwoCityScheduling {

    static int twoCitySchedCost(int[][] costs) {
        int n=(costs.length/2);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(Math.abs(b[1]-b[0])-Math.abs(a[1]-a[0])));
        for(int a[]:costs){
            pq.add(a);
        }
        int a=0,b=0;
        int sum=0;
        while(!pq.isEmpty()){
            int ar[]=pq.poll();
            if(b>=n||(ar[0]<ar[1] && a<n)) {a++; sum+=ar[0];}
            else if(b<n){b++; sum+=ar[1];}

        }
        return sum;

    }

    public static void main(String[] args) {
        //        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
        int a[][]={{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(a));
    }
}