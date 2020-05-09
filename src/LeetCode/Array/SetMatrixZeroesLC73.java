package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 20/04/20 8:02 AM 
 */public class SetMatrixZeroesLC73 {

    static void setZeroes(int[][] matrix) {
        boolean fr=false,fc=false;
        int m=matrix.length;
        int n=matrix[0].length;

        for (int i = 0; i <m ; i++) {
            if(matrix[i][0]==0){
                fc=true;
                break;
            }
        }

        for (int j = 0; j <n ; j++) {
            if(matrix[0][j]==0){
                fr=true;
                break;
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if(matrix[i][0]==0  || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(fr){
            for (int i = 0; i <n ; i++) {
                matrix[0][i]=0;
            }
        }

        if(fc){
            for (int i = 0; i <m ; i++) {
                matrix[i][0]=0;
            }
        }
    }





     public static void main(String[] args) {
        int matrix[][]={{1,1,1},{0,1,1},{1,1,1}};
         setZeroes(matrix);
         System.out.println(Arrays.deepToString(matrix));
    }
}