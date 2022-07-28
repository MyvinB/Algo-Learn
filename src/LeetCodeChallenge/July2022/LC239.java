package LeetCodeChallenge.July2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC239 {

    public static void main(String[] args) {
        int[] p = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingDeque(p,3)));
    }
    //0(nk) in worst case
    public static int[] maxSlidingWindow(int[] nums, int k) {
         int pos = -1;
         int n = nums.length;
         int[] res = new int[n-k+1];
         for(int i=0;i<n-k+1;i++){
             if(pos<i) pos = findPos(i,i+k,nums);
             //-1 one cause it's already at index including number
             else pos= nums[pos]>nums[i+k-1]?pos:i+k-1;
             res[i] = nums[pos];
         }
         return res;
    }

    public static int findPos(int i, int j, int nums[]){
        int pos = i;
        while(i<j){
            if(nums[i]>nums[pos]) pos = i;
            i++;
        }
        return pos;
    }

    public static int[] maxSlidingDeque(int[] nums, int k) {
        int pos = -1;
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx=0;
        for(int i=0;i<n;i++){

            //Check for out of bounds index i+k-1 gives the first index of what we require
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            //We are storing elements in decreasing order so if we find something greater we do not need less elements in the que
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }

            deque.offer(i);
            //We have now gone through one set of elements to find max next time it's just adding an element and deleting it from the back
            if(i>=k-1)
            res[idx++] = nums[deque.peek()];
        }
        return res;
    }


}
