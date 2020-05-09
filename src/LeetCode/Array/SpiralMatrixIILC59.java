package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 21/04/20 8:59 AM 
 */public class SpiralMatrixIILC59 {

    static int[][] generateMatrix(int n) {
        int mat[][]=new int[n][n];
        //boundary condition;
        int rowBegin=0;
        int rowEnd=n-1;
        int colBegin=0;
        int colEnd=n-1;
        int no=0;
        while(rowBegin<=rowEnd && colBegin<=colEnd ){
            for (int i = colBegin; i <=colEnd ; i++) {
                mat[rowBegin][i]=++no;
            }
            rowBegin++;
            for (int i = rowBegin; i <=rowEnd ; i++) {
                mat[i][colEnd]=++no;
            }
            colEnd--;
            if(rowBegin<=rowEnd){
                for (int i = colEnd; i>=colBegin ; i--) {
                    mat[rowEnd][i]=++no;
                }
            }
            rowEnd--;
            if(colBegin<=colEnd){
                for (int i = rowEnd; i >=rowBegin ; i--) {
                    mat[i][colBegin]=++no;
                }
            }
            colBegin++;
        }
        return mat;
    }



     public static void main(String[] args) {
         System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
}