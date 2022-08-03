package LeetCodeChallenge.Aug2022;

public class LC378 {

    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m-1][n-1];
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(getRank(matrix,mid)<k){
                lo = mid+1;
            }else hi = mid;
        }
        return lo;
    }


    public int getRank(int[][] matrix,int target){
        int n = matrix.length;
        int count = 0,i = n-1,j = 0;
        while(i>=0 && j<n){
            if(matrix[i][j]>target){
                i--;
            }else {
                count+= i+1;
                j++;
            }
        }
        return count;
    }
}
