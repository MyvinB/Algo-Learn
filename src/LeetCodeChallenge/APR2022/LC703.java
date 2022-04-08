package LeetCodeChallenge.APR2022;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 6:21 AM 4/8/2022
 * Time Taken:
 */
public class LC703 {

    public static void main(String[] args) {

    }

    class KthLargest {
        PriorityQueue<Integer> pq;
        int k ;
        public KthLargest(int k, int[] nums) {
            k = this.k;
            pq = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                pq.offer(nums[i]);
            }
        }

        public int add(int val) {
            if(pq.size()<k){
                pq.offer(val);
            }else if(pq.peek()<val){
                pq.poll();
                pq.offer(val);
            }

            return pq.peek();
        }
    }
}
