package Contest.LeetCode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:11 AM 3/13/2022
 * Time Taken:
 */
public class MaximizeTheTopmostElementAfterKMoves {

    public static void main(String[] args) {
        int[] t = new int[]{2};
        System.out.println(maximumTop(t,1));
    }

    public static int maximumTop(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        if(k==1 && nums.length==1) return -1;
        if(k==1) return nums[1];
        int t = k-1;
        for(int i =0;i<nums.length;i++){
            if(t==0) break;
            pq.offer(nums[i]);
            t--;
        }
        return pq.poll();
    }
}
