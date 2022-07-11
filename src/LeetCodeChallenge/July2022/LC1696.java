package LeetCodeChallenge.July2022;

import java.util.PriorityQueue;

public class LC1696 {

    public static void main(String[] args) {

    }

    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.offer(new int[]{nums[0],0});
        /*
         * i-maxScoreIndex <=k
         * i-k<=maxScoreIndex is valid so let's make it invalid and keep polling till we find a valid soln
         * ie i-k>maxScoreIndex
         * Since we take the maxScore all the time we pop we check valid and hence proceed forwards hence getting max result
         * */
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            while(i-k>pq.peek()[1]){
                pq.poll();
            }
            int cur[] = pq.peek();
            max = cur[0] + nums[i];
            pq.offer(new int[]{max,i});
        }
        return max;
    }
}
