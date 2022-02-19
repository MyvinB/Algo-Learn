package LeetCodeChallenge.Feb2022;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 10:28 PM 2/19/2022
 * Time Taken:
 */
public class LC1675 {

    public static void main(String[] args) {
        int nums[] = new int[]{3,5};
        //2 2 6 4
        //2 2 4 6
        // 2 2 3 4
        // 2 2 2 3

        System.out.println(minimumDeviation(nums));
    }

    public static int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            if(i%2!=0) i=i*2;
            min = Math.min(min,i);
            pq.add(i);
        }
        int diff = Integer.MAX_VALUE;
        while(pq.peek()%2==0){
            int max = pq.poll();
            diff = Math.min(diff,max-min);
            min = Math.min(min,max/2);
            pq.add(max/2);
        }
        diff = Math.min(diff,pq.peek()-min);
        return diff;
    }
}
