package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 7:39 AM 4/8/2022
 * Time Taken:
 */
public class LC931 {

    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left = j-1>=0?dp[i-1][j-1]:Integer.MAX_VALUE;
                int middle = dp[i-1][j]; //No worry of overflow
                int right =j+1<n? dp[i-1][j+1]:Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j]+Math.min(Math.min(left,middle),right);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(dp[n-1][i],min);
        }
        return min;
    }
}
