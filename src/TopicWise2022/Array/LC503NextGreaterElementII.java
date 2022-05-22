package TopicWise2022.Array;

import java.util.Stack;

public class LC503NextGreaterElementII {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i%n]>=stack.peek()){
                stack.pop();
            }
            if(i<n){
                res[i] = !stack.isEmpty()? stack.peek():-1;
            }

            stack.push(nums[i%n]);
        }
        return res;

    }
}
