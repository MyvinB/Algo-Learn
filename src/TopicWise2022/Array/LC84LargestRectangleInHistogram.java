package TopicWise2022.Array;

import java.util.Arrays;
import java.util.Stack;

public class LC84LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] t = new int[]{2,1,5,6,2,3,1};
        System.out.println(largestRectangleArea(t));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) leftMin[i] = 0;
            else leftMin[i] = stack.peek()+1;
            stack.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) rightMin[i] = n-1;
            else rightMin[i] = stack.peek()-1;
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            max = Math.max(((rightMin[i]-leftMin[i])+1)*heights[i],max );
        }
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));
        return max;
    }


    public int largestRectangleAreaOnePass(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && ( i==n || heights[stack.peek()]>=heights[i]) ){
                int width;
                int height = heights[stack.pop()];
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                max = Math.max(width*height,max);
            }
            stack.push(i);
        }
        return max;
    }
}
