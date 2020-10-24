package LeetCode.Stack;

import java.util.Stack;

public class LC456132Pattern {

    public static void main(String[] args) {
        int a[] ={-1,3,2,0};
        //example of pop
        int b[]={3,5,0,3,4};
    }

    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int minNum[]=new int[nums.length];
        minNum[0]=nums[0];
        for(int i=1;i<n;i++){
            minNum[i] = Math.min(minNum[i-1],nums[i]);
        }
        Stack<Integer> stack=new Stack();
        for(int j=n-1;j>0;j--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[j]){
                if(nums[stack.peek()] >minNum[j-1]){
                    return true;
                }
                stack.pop();
            }
            stack.push(j);
        }
        return false;
    }

}
