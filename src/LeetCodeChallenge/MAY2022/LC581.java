package LeetCodeChallenge.MAY2022;

import java.util.Stack;

public class LC581 {

    //o(n) space and o(n) time
    public int findUnsortedSubarrayMonotonicStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int low = nums.length-1;
        int high = 0;
        int i = 0;
        while(i<nums.length){
            if(stack.isEmpty()){
                stack.push(i);
                i++;
            }
            else{
                if(nums[stack.peek()]>nums[i]){
                    low = Math.min(stack.peek(),low);
                    stack.pop();
                }else{
                    stack.push(i);
                    i++;
                }
            }
        }
        i = nums.length-1;
        stack.clear();
        while(i>=0){
            if(stack.isEmpty()){
                stack.push(i);
                i--;
            }
            else{
                if(nums[stack.peek()]<nums[i]){
                    high = Math.max(high,stack.peek());
                    stack.pop();
                }
                else {
                    stack.push(i);
                    i--;
                }
            }
        }
        if(low>=high) return 0;
        return high-low+1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1;
        int end = -2;
        for(int i=0;i<len;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[len-i-1]);

            if(nums[i]<max){
                end = i;
            }
            if(nums[len-i-1]>min){
                start = len-i-1;
            }
        }
        return end-start+1;
    }


}
