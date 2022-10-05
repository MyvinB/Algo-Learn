package LeetCodeChallenge.Oct2022.DP.Square;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {

    public static void main(String[] args) {
        int[] t = new int[]{1,0};
        System.out.println(findMaxArea(t));
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') temp[j]+=1;
                else temp[j] = 0;
            }
            max = Math.max(max,findMaxArea(temp));
        }
        return max;
    }


    public static int findMaxArea(int[] A){
        System.out.println(Arrays.toString(A));
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea  = 0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || A[stack.peek()]>=A[i])){
                int height = A[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else width = i-stack.peek()-1;
                int area = height * width;
                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
