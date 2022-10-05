package LeetCodeChallenge.Oct2022.DP.Square;

public class MaximumSquare {

    public static void main(String[] args) {

    }


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int area = 0;
        for(int i=0;i<m;i++) dp[i][0] = matrix[i][0]-'0';
        for(int j=0;j<n;j++) dp[0][j] = matrix[0][j]-'0';
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='0') dp[i][j] = 0;
                else{
                    int up = dp[i-1][j];
                    int diagonal = dp[i-1][j-1];
                    int left = dp[i][j-1];
                    dp[i][j] = 1 + Math.min(up,Math.min(diagonal,left));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                area = Math.max(area,dp[i][j]);
            }
        }
        return area*area;
    }
}
