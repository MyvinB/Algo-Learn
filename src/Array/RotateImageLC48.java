package Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 26/03/20 9:28 AM 
 */
public class RotateImageLC48 {

    static void rotate(int[][] matrix) {
        int temp=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i; j <matrix[i].length ; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int n=matrix[0].length;

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length/2 ; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }

    }


    public static void main(String[] args) {

        int a[][]={{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        System.out.println(Arrays.deepToString(a));


    }
}