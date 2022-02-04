package Company.ZopSmart;

/**
 * @author mmichaelbarboza
 * on 11:15 AM 2/4/2022
 * Time Taken:
 */
public class LC74 {

    public static void main(String[] args) {
        int t[][] = new int[][]{{1,1}};
        System.out.println(searchMatrix(t,2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low =0;
        int high = matrix.length* matrix[0].length-1;
        int colMod=matrix[0].length;
        while(low<=high){
            int mid = low +(high-low)/2;
            int row = mid/colMod;
            int col = mid%colMod;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                high=mid-1;
            }else low=mid+1;

        }
        return false;
    }


}
