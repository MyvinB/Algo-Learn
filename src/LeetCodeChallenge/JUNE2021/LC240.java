package LeetCodeChallenge.JUNE2021;

public class LC240 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = n-1;
        while(r<m && c>=0){
            if(target==matrix[r][c]) return true;
            //Increment the row cause we are already at the greatest part of the column last index;
            else if(target>matrix[r][c]) r++;
            ///decrement to find a smaller index in a lower column
            else c--;
        }
        return false;
    }
}
