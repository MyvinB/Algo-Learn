package LeetCode.Array;

/*
 @author Myvin Barboza
 23/04/20 6:22 PM 
 */public class SearchIna2dMatrixLC240andLC74 {

     /*
     [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

     * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int r=0;
        int c=matrix[0].length-1;
        int row=matrix.length-1;
        while(r<=row && c>=0){
            if(target==matrix[r][c]) return true;
            if(target>matrix[r][c]) r++;
            else c--;
        }
        return false;
    }


     public static void main(String[] args) {

    }
}