package LeetCodeChallenge.JAN2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:25 PM 1/29/2022
 */
public class LC84 {

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    //Striver you rock hope i never forger this 3 pas soln
    public static int largestRectangleArea(int[] heights) {
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        //Calculating left minimum for each index
        for(int i=0;i<heights.length;i++){

            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            //Empty stack left more index
            if(stack.isEmpty()) leftSmaller[i]=0;
            //getting left boundary
            else leftSmaller[i] = stack.peek()+1;
            //Adding each index
            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();

        //Calculating right maxima for each index
        for(int i=heights.length-1;i>=0;i--){

            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()) rightSmaller[i] = heights.length-1;
            else rightSmaller[i]=stack.peek()-1;
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int area = (rightSmaller[i]-leftSmaller[i]+1) * heights[i];
            max = Math.max(max,area);
        }

        return max;
    }

    public static int largestRectangleAreaOnePass(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || heights[i]<=heights[stack.peek()])){
                //if your going right and you find a val thats min its the right min
                //thats the val we are finding for
                int width;
                int height = heights[stack.pop()];
                if(stack.isEmpty()) width=i;
                // 1 2 3 4 say you want to find only len from 2 to 3 and your lower index is 1 and higher one is 4 ans would be 4-1-1
                //basically -1 one to delete extra element
                else width = i-stack.peek()-1;
                max = Math.max(max,width*height);
            }

            stack.push(i);
        }
        return max;
    }


}
