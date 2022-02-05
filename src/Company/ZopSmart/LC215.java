package Company.ZopSmart;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 10:02 PM 2/4/2022
 * Time Taken:
 */
public class LC215 {

    public static void main(String[] args) {
        int t[] = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(t,3));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.poll();
    }
    
}
