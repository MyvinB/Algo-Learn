package Array;

/*
 @author Myvin Barboza
 21/04/20 9:14 AM 
 */

/*matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]*/
public class SearchA2DMatrixLC74 {

    static  boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int i=0,j=0;
        int low=matrix[i][j];
        int high=matrix[i][n];

        while (i<=m ){
            low=matrix[i][0];
            high=matrix[i][n];
            if(target<=high && target >=low){
                low=0;
                high=n;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(target>matrix[i][mid]) low=mid+1;
                    if(target<matrix[i][mid]) high=mid-1;
                    if(target==matrix[i][mid]) return true;
                }
                return false;
            }
            i++;
        }
        return false;

    }


    public static void main(String[] args) {
        int mat[][]={
                {1,3,5,7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},

        };
        System.out.println(searchMatrix(mat,13));
    }
}