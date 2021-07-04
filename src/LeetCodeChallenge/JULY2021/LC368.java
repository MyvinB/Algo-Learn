package LeetCodeChallenge.JULY2021;

import java.util.Arrays;
import java.util.TreeSet;

public class LC368 {


    public static void main(String[] args) {
        //new int[]{1, 4, 9, -10, 4} 7
//        System.out.println(findMaximumSubArray(new int[]{2,2,-1}, 0));
        System.out.println(maxSumSubmatrix(new int[][]{{2,2,-1}},0));
    }

    public static  int maxSumSubmatrix(int[][] matrix, int k) {
        int col = matrix[0].length;
        int row = matrix.length;
        int max = Integer.MIN_VALUE;
        for(int r=0;r<row;r++){
            int[] colSum = new int[col];
            for (int i = r; i < row ; i++) {
                for (int c = 0; c <col ; c++) {
                    colSum[c] += matrix[i][c];
                }
                max = Math.max(max,findMaximumSubArray(colSum,k));
                System.out.println(max);


            }
        }
        return max;
    }

    public static int findMaximumSubArray(int a[], int k) {
        int res = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0, right = 0; i < a.length; i++) {
            right += a[i];
            Integer left = set.ceiling(right - k); //right-left<=k -> left>=right-left
            if (left != null) {
                res = Math.max(res, right - left); //comparing maximum subarray.
            }
            set.add(right);
        }
        return res;
    }

}
