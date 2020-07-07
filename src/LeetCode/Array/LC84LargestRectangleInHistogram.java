package LeetCode.Array;/*
 @author Myvin Barboza
 07/07/20 11:48 AM
 help:https://www.youtube.com/watch?v=oi1SBpL2PyE
 */

import java.util.Stack;

public class LC84LargestRectangleInHistogram {

    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack =new Stack<>();
        stack.push(-1);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < heights.length ; i++) {
            while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                max=Math.max(max,heights[stack.pop()]* (i-stack.peek()-1));
            }
            stack.push(i);
        }

        if(stack.peek()!=-1){
            max=Math.max(max,heights[stack.pop()]* (n-stack.peek()-1));
        }
        return max;
    }


}
