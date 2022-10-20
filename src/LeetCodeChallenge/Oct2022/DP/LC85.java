package LeetCodeChallenge.Oct2022.DP;

import java.util.Stack;

public class LC85 {

    public int maximalRectangle(char[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         int[] height = new int[n];
         int max = 0;
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(matrix[i][j]=='1'){
                     height[j]++;
                 }else height[j] = 0;
             }
             int largestRectangle = largestRectangleAreaOnePass(height);
             max = Math.max(largestRectangle,max);
         }
         return max;
    }

    public int largestRectangleAreaOnePass(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i=-0;i<=n;i++){
            while(!stack.isEmpty() && (i==n||heights[i]<=heights[stack.peek()])){
                int val = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                area = Math.max(area,width*val);
            }
            stack.push(i);
        }
        return area;
    }
}
