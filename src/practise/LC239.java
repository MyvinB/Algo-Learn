package practise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 12:58 PM 11/29/2021
 */
public class LC239 {

    public static void main(String[] args) {
      int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
      System.out.println(Arrays.toString(maxSlidingWindowDeque(nums,3)));
      System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }

    //nlogk
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //https://www.youtube.com/watch?v=LiSdD3ljCIE
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] ans = new int[n-k+1];
        int j=0;
        for(int i=0;i<n;i++){
            maxHeap.add(new int[]{nums[i],i});
            if(i+1>=k) ans[j++]=maxHeap.peek()[0];
            while(maxHeap.size() >0 && i-maxHeap.peek()[1]+1>=k){
                maxHeap.poll();
            }
        }
        return ans;
    }


    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int ri =0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty() && i-q.peek()+1>k){
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i+1>=k)
            res[ri++] = nums[q.peek()];
        }
        return res;
    }
}
