package LeetCodeChallenge.Oct2022.DP.PartionDp;

import java.util.Arrays;

public class LC1547 {

    public static void main(String[] args) {

    }

    public int minCost(int n, int[] cuts) {
        int N = cuts.length;
        int[] cutsM = new int[N+2];
        cutsM[N+1] = n;
        for(int i=0;i<N;i++) cutsM[i+1] = cuts[i];
        return recurMemo(cuts,1,N);
    }
    //Skipping memo usecase to tabulate
    public int recurMemo(int[] cuts, int i, int j){
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = cuts[j+1]-cuts[i-1];
            int lHalf = recurMemo(cuts,i,k-1);
            int rHalf = recurMemo(cuts,k+1,j);
            min = Math.min (cost+lHalf+rHalf,min);
        }
        return min;
    }


    public int tabulation(int[] cuts, int n){
        Arrays.sort(cuts);
        int N = cuts.length;
        int[] cutsM = new int[N+2];
        cutsM[N+1] = n;
        for(int i=0;i<N;i++) cutsM[i+1] = cuts[i];
        int[][] dp = new int[N+2][N+2];

        for(int i=N;i>=1;i--){
            for(int j=i;j<=N;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = cutsM[j+1]-cutsM[i-1];
                    int lHalf = dp[i][k-1];
                    int rHalf = dp[k+1][j];
                    min = Math.min (cost+lHalf+rHalf,min);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][N];
    }

}
