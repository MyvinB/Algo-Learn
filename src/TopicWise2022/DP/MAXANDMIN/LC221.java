package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 9:40 PM 4/5/2022
 * Time Taken:
 */
public class LC221 {

    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxA = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    int left = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                    int up = dp[i-1][j];
                    //Taking minimuim value of all 3 we would get the possible square if zero is there then dp current value would be one
                    int min = Math.min(left,diagonal);
                    min = Math.min(min,up);
                    //Adding one to the mimum value tells you the square
                    dp[i][j] = 1+min;
                    maxA = Math.max(maxA,dp[i][j]);
                }
            }
        }
        return maxA*maxA;
    }
}
