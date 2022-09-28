package LeetCodeChallenge.Sep2022.DpPractise.PartionDp;

import java.util.Arrays;

public class MatrixMultiplication {

    public static void main(String[] args) {

    }

    public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recur(arr,1,N-1, dp);
    }

    public static int recur(int[] arr,int i,int j,int[][] dp){
        //base case
        if(i==j) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
                        //calcualting final operations
            int ans = arr[i-1]*arr[k]*arr[j] + recur(arr,i,k,dp) + recur(arr,k+1,j,dp);
            min = Math.min(min,ans);
        }
        return dp[i][j] = min;
    }

    public int tabulation(int[] arr,int N){
        int[][] dp = new int[N][N];
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    //calcualting final operations
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min,steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N-1];
    }
}
