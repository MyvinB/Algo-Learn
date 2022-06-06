package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC304RangeSumQuery2D {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix a = new NumMatrix(matrix);
        NumMatrix1 b = new NumMatrix1(matrix);
      //  System.out.println(a.sumRegion(2, 1, 4, 3));
        System.out.println(b.sumRegion(2,1,4,3));
    }

    static class NumMatrix {
        int[][] rowPreSum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            rowPreSum = new int[m][n];
            for(int i=0;i<m;i++){
                int preSum =0;
                for(int j=0;j<n;j++){
                    preSum += matrix[i][j];
                    rowPreSum[i][j] = preSum;
                }
            }
            System.out.println(Arrays.deepToString(rowPreSum));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int preRowDel =0,totalRowSum=0;
            int totalSum =0;
            for(int i=row1;i<=row2;i++){
                if(col1!=0) preRowDel = rowPreSum[i][col1-1];
                totalRowSum = rowPreSum[i][col2]-preRowDel;
                totalSum += totalRowSum;
            }
            return totalSum;
        }
    }


    static class NumMatrix1 {
        int[][] T;
        public NumMatrix1(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            T = new int[m+1][n+1];
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    T[i][j] = matrix[i-1][j-1] + T[i-1][j] + T[i][j-1] -T[i-1][j-1];
                }
            }
            System.out.println(Arrays.deepToString(T));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int r1 = row1+1,c1 = col1+1,r2 = row2+1,c2 = col2+1;
            return T[r2][c2]-T[r1-1][c2]-T[r2][c1-1] +T[r1-1][c1-1];
        }
    }
}
