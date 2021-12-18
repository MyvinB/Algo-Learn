package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 10:26 PM 12/18/2021
 */
public class LC221 {

    public static void main(String[] args) {
        String[][] check = {{"1", "0", "1", "0", "0"},
                            {"1", "0", "1", "1", "1"},
                            {"1", "1", "1", "1", "1"},
                            {"1", "0", "0", "1", "0"}};

        maximalSquare(check);

    }

    public static int maximalSquare(String[][] matrix) {
        int r = matrix.length,c=matrix[0].length;
        int[][] dp = new int[r+1][c+1];
        int largest = 0;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(matrix[i-1][j-1].equals("1")){
                    dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
                largest = Math.max(largest,dp[i][j]);
            }
        }
        System.out.println(largest);
        return largest*largest;
    }
}
