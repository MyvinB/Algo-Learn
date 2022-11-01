package LeetCodeChallenge.Nov2022.Revise;

import java.util.Stack;

public class LC84 {

    public static void main(String[] args) {

    }
    //using leftMin+1 and rightMin-1
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) stack.pop();
            if(stack.isEmpty()) left[i] = 0;
            else left[i]=stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) stack.pop();
            if(stack.isEmpty()) right[i] = n-1;
            else right[i] = stack.peek()-1;
            stack.push(i);
        }
        int area = 0;
        for(int i=0;i<n;i++){
            int curArea = (right[i]-left[i]+1)*heights[i];
            area = Math.max(area,curArea);
        }
        return area;
    }


    public int largestRectangleAreaOpti(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int area = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() &&( i==n|| heights[stack.peek()]>heights[i] )){
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                area = Math.max(area,height*width);
            }
            stack.push(i);
        }
        return area;
    }
}
