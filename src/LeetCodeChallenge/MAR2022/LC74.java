package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:43 AM 3/30/2022
 * Time Taken:
 */
public class LC74 {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(mat,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m*n-1; //total elemnts and zero indexing
        while(low<high){
            int mid = low+ (high-low)/2;
            if(target >matrix[mid/m][mid%m]){
                low = mid+1;
            }
            else high = mid;
        }
        return target == matrix[low/m][low%m];
    }


}
