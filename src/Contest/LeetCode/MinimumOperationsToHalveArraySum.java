package Contest.LeetCode;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 8:13 PM 3/19/2022
 * Time Taken:
 */
public class MinimumOperationsToHalveArraySum {

    public static void main(String[] args) {
        int[] t = new int[]{6,58,10,84,35,8,22,64,1,78,86,71,77};
        int[] r = new int[]{18,22,62,61,1,88,17,98,38,32,51,57,7,29,40,61,62,13,89,41,73,85,88,60,59,76,71,76,76,41,29,43,19,9,79};
        int[] p = new int[]{3,8,20};
        int[] q = new int[]{5,19,8,1};
        int[] e = new int[]{1};
        System.out.println(halveArray(e));
    }

    public static int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->Double.compare(b,a));
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            pq.offer((double) nums[i]);
        }
        double half = sum/2;
        int count = 0;
        while(!pq.isEmpty() && sum>half){
           double val =  pq.poll();
           sum += -val + val/2;
           pq.offer(val/2);
           count++;
        }
        return count;


    }
}
