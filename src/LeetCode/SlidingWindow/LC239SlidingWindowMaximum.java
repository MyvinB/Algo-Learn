package LeetCode.SlidingWindow;/*
 @author Myvin Barboza
 06/08/20 10:57 AM 
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239SlidingWindowMaximum {

    public static void main(String[] args) {
        int a[]= {1,3,-1,-3,5,3,6,7};
        int b[]={2,4,7};
        //System.out.println(maxSlidingWindow(a,3));
    System.out.println(maxSlidingWindowA(b,2));
    }

    ///way faster really simple too deque takes space and
    //also gets rid of unecessary storage
    //eg 1 3 -1 -3 5 3 6 7
    //here the max is 3 for subarray {1,3,-1} now this is for index 0,3
    //now for index 1 to 4 we need to compare the new element with the max if it is greater we have out new max pos
    //if by case our max remains the same we have a new index 2-4 but out max is still one we perform the search again for max where 1>2
    //however in deque we store -1 -3 and then we see 5 we pop -3 -1 but we are storing thing in the deque now imagine a worst case where the numbers are huge
    //so doing it this way is more efficient


    static int[] maxSlidingWindowA(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        int pos=-1;
        int idx=0;
        for(int i=0;i<n-k+1;i++){
            if(pos<i)
                pos=findMax(i,i+k,nums);
            else pos=nums[pos]>nums[i+k-1]?pos:i+k-1;
            res[idx++]=nums[pos];
        }
        return res;
    }

    static int findMax(int i,int j,int nums[]){
        int pos=i;
        while(i<j){
            if(nums[i]>nums[pos])pos=i;
            i++;
        }
        return pos;
    }

    static  int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        int idx=0;
        for(int i=0;i<nums.length;i++){

            //to remove out of order elements
            while(!deque.isEmpty() && deque.peek()<i-k+1){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }


            deque.offer(i);

            if(i>=k-1){
                res[idx++]=nums[deque.peek()];
            }
        }
        return res;
    }
}
