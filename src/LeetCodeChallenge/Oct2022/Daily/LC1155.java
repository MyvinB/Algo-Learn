package LeetCodeChallenge.Oct2022.Daily;

import java.util.Arrays;

public class LC1155 {

    static int MOD = 1000000000 + 7;

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(n,k,target,dp);
    }

    public static int recurMemo(int n, int k,int target,int[][] dp){
        if(target==0 && n==0) return 1;
        //if no dice left to throw //   //Cannot  reach target and still have number of throws
        if(n==0 || target==0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int noOfWays = 0;
        for(int i=1;i<=k;i++){
            if(target>=i)
                noOfWays= (noOfWays + recurMemo(n-1,k,target-i,dp))%MOD;
            else break;
        }
        return dp[n][target]  = noOfWays;
    }

    public int tabulation(int n,int k,int target){
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                for(int p=1;p<=k;p++){
                    if(j>=p)
                        dp[i][j]= (dp[i][j] + dp[i-1][j-p])%MOD;
                    else break;
                }
            }
        }
        return dp[n][target];
    }
}
