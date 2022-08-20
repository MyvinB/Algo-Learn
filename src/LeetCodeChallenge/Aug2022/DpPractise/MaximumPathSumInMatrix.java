package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;

public class MaximumPathSumInMatrix {

    public static void main(String[] args) {

    }

    public static int spaceOpti(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MIN_VALUE;
        int[] dp = new int[n];
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[j] = matrix[i][j];
                else{
                    int up = prev[j];
                    int leftDig = Integer.MIN_VALUE;
                    int rightDig = Integer.MIN_VALUE;
                    if(j>0) leftDig = prev[j-1];
                    if(j<n-1) rightDig = prev[j+1];
                    dp[j] = matrix[i][j] + Math.max(up,Math.max(leftDig,rightDig));
                }
            }
            prev = Arrays.copyOf(dp,dp.length);
        }
        for(int j=0;j<n;j++){
            maxi = Math.max(dp[j],maxi);
        }
        return maxi;
    }


    public static int tabulation(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j] = matrix[i][j];
                else{
                    int up = dp[i-1][j];
                    int leftDig = Integer.MIN_VALUE;
                    int rightDig = Integer.MIN_VALUE;
                    if(j>0) leftDig = dp[i-1][j-1];
                    if(j<n-1) rightDig = dp[i-1][j+1];
                    dp[i][j] = matrix[i][j] + Math.max(up,Math.max(leftDig,rightDig));
                }
            }
        }
        for(int j=0;j<n;j++){
            maxi = Math.max(dp[m-1][j],maxi);
        }
        return maxi;
    }

    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for(int[] a :dp){
            Arrays.fill(a,-1);
        }
        for(int j=0;j<n;j++){
            maxi = Math.max(maxi,recurMemo(matrix,m-1,j,dp));
        }
        return maxi;
    }



    public static int recurMemo(int[][] matrix,int i,int j,int[][] dp){
        //base case
        if( j<0 || j>= matrix[0].length) return Integer.MIN_VALUE;
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up = recurMemo(matrix,i-1,j,dp);
        int leftDig  = recurMemo(matrix,i-1,j-1,dp);
        int rightDig = recurMemo(matrix,i-1,j+1,dp);
        return dp[i][j] =matrix[i][j] + Math.max(up,Math.max(leftDig,rightDig));
    }

    public static int recur(int[][] matrix,int i,int j){
        //base case
        if( j<0 || j>= matrix[0].length) return Integer.MIN_VALUE;
        if(i==0) return matrix[0][j];
        int up = recur(matrix,i-1,j);
        int leftDig  = recur(matrix,i-1,j-1);
        int rightDig = recur(matrix,i-1,j+1);
        return matrix[i][j] + Math.max(up,Math.max(leftDig,rightDig));
    }
}
