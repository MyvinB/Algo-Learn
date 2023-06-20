package Year2023.JuneHalf;

import java.util.Arrays;

public class LC73 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] t1 = new int[][]{{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        int[][] t2 = new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};

        //setZeroesBetter(t);
        setZeroes(t2);
    }


    //Better Approach
    public static void setZeroesBetter(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i] =1;
                    col[i] =1;
                }
            }
        }
        //Setting -1 to zero
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(row[i]==1 || col[j]==1) matrix[i][j] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int col0 = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) col0=1;
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0 ) {
                    matrix[i][j]=0;
                }
            }
            if(col0==1) matrix[i][0]=0;
        }

    }
}
