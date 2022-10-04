package LeetCodeChallenge.Oct2022.DP.PartionDp;

import java.util.Arrays;

public class LC312BurstBalloon {

    public static void main(String[] args) {
        int[] k = new int[]{3,1,5,8};
        System.out.println(maxCoins(k));
    }

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+2];
        a[0] = 1; a[n+1]=1;
        for(int i=0;i<n;i++){
            a[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(a,1,n,dp);
    }


    public static int recurMemo(int[] A,int i, int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost = A[i-1]*A[k]*A[j+1] + recurMemo(A,i,k-1,dp)+ recurMemo(A,k+1,j,dp);
            max = Math.max(max,cost);
        }
        return dp[i][j] = max;
    }

    public int tabulation(int[] nums){
        int n = nums.length;
        int[] A = new int[n+2];
        A[0] = 1; A[n+1]=1;
        for(int i=0;i<n;i++){
            A[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i =n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int max = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = A[i-1]*A[k]*A[j+1] + dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max,cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
