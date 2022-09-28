package LeetCodeChallenge.Sep2022.DpPractise.PartionDp;

import java.util.Arrays;

public class LC1547MinimumCostToCutAStick {

    public static void main(String[] args) {

    }

    public int minCost(int n, int[] cuts) {
        int N = cuts.length;
        Arrays.sort(cuts);
        int[] cutsM = new int[N+2];
        cutsM[N+1] = n;
        for(int i=0;i<N;i++) cutsM[i+1] = cuts[i];
        int[][] dp = new int[N+2][N+2];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(cutsM,1,N,dp);
    }

    public int recurMemo(int[] cuts,int i, int j, int[][] dp){
        //Crossing boundary
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        //decision choice to make the cut
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<=j;k++){
            int cost = cuts[j+1]-cuts[i-1] + recurMemo(cuts,i,k-1,dp) +recurMemo(cuts,k+1,j,dp);
            min = Math.min(min,cost);
        }
        return dp[i][j] = min;
    }

    public int tabulation(int[] cuts, int n){
        int N = cuts.length;
        Arrays.sort(cuts);
        int[] cutsM = new int[N+2];
        cutsM[N+1] = n;
        for(int i=0;i<N;i++) cutsM[i+1] = cuts[i];
        int[][] dp = new int[N+2][N+2];
        System.out.println(Arrays.toString(cutsM));
        for(int i=N;i>=1;i--){
            for(int j=i;j<=N;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = cutsM[j+1]-cutsM[i-1] + dp[i][k-1] +dp[k+1][j];
                    min = Math.min(min,cost);
                }
                dp[i][j] = min;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[1][N];
    }
}
