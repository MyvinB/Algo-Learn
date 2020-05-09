package LeetCode.DP;

/*
 @author Myvin Barboza
 27/04/20 3:10 PM 
 */public class MaximalSquareLC221 {

    static int maximalSquare(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int rows=matrix.length; int col=matrix[0].length;
        int dp[][]=new int[rows+1][col+1];
        int max=0;
        for (int i = 1; i <=rows ; i++) {
            for (int j = 1; j <=col ; j++) {
                if(matrix[i-1][j-1]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max* max;
    }


     public static void main(String[] args) {
         int a[][] = {{1,0,1,0,0},
                 {1,0,1,1,1},
                 {1,1,1,1,1},
                 {1,0,0,1,0}};
         System.out.println(maximalSquare(a));

    }
}