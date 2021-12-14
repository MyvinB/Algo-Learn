package LeetCode.DP;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 1:36 PM 12/13/2021
 */
public class MatrixBlockSumLc1314 {

    public static void main(String[] args) {
        int [][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        matrixBlockSum(mat,1);
    }

    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
        System.out.println(Arrays.deepToString(rangeSum));

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        System.out.println(Arrays.deepToString(ans));

        return ans;
    }
}
