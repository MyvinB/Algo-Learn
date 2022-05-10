package LeetCodeChallenge.MAY2022;

import java.util.Arrays;
import java.util.Stack;

public class LC456 {


    public static void main(String[] args) {
        //[1,0,1,-4,-3]
        int t[] = new int[]{1,0,1,-4,-3};
        find132patternMonoStack(t);
    }




    public static boolean find132patternMonoStack(int[] nums) {
        //[1,3,2,4,5,6,7,8,9,10]
        Stack<Integer> stack = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<thirdElement) return true;
            while(!stack.isEmpty() && stack.peek() <nums[i]) thirdElement = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
