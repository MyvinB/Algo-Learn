package LeetCodeChallenge.Oct2022.Stack;

import java.util.Arrays;
import java.util.Stack;

public class LC84 {

    public static void main(String[] args) {
        int[] t = new int[]{1,0};
        System.out.println(largestRectangleAreaOptimised(t));
    }
    //tghink of boundary as plus
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) left[i] = 0;
            else left[i] = stack.peek()+1; //When we find the lower element we need +1 index cause there we will start from
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) right[i] = n-1;
            else right[i] = stack.peek()-1;
            stack.push(i);
        }
        System.out.println(Arrays.toString(right));
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int area = (right[i]-left[i]+1) *heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static int largestRectangleAreaOptimised(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n||heights[stack.peek()]>=heights[i])){
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width = i; //o to n
                else width = i-stack.peek()-1; // and since we need to minus left boundary -1
                int area = height *width;
                maxArea = Math.max(area,maxArea);
            }

            stack.push(i);
        }
        return maxArea;
    }
}
