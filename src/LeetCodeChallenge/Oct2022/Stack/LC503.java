package LeetCodeChallenge.Oct2022.Stack;

import java.util.Stack;

public class LC503 {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n)
                res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
