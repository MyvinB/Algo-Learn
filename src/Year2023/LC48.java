package Year2023;

import java.util.Arrays;

public class LC48 {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},
                                {4,5,6},
                                {7,8,9}};
       rotate(m);
    }

    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        //Reversing the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
       // System.out.println(Arrays.deepToString(matrix));

    }
}
