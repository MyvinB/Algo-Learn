package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        int[] t = new int[]{2,5,7,8,10};
        System.out.println(spaceOpti(t,t.length));
    }

    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(price,n,n-1,dp);
    }


    public static int recurMemo(int[] price,int lenLeft,int index,int[][] dp){
        if(index==0){
            //here the rod length is one so dividing the remaining pieces by one give n and then multiply it
            return price[0] * lenLeft;
        }
        if(dp[index][lenLeft]!=-1) return dp[index][lenLeft];
        int rodLength = index +1;
        int notTake = recurMemo(price,lenLeft,index-1,dp);
        //Do know the take is recursive and the index is not changing so we can keep taking the same rod length at the end we need the decision with max amount
        int take = Integer.MIN_VALUE;
        if(rodLength<=lenLeft) take = price[index] + recurMemo(price,lenLeft-rodLength,index,dp);
        return dp[index][lenLeft] = Math.max(take,notTake);
    }

    //Lets tabulate
    public static int tabulation(int[] price,int n){
        int[][] dp = new int[n][n+1];
        //base case
        for(int i=0;i<=n;i++) dp[0][i] = i * price[0];

        for(int i=1;i<n;i++){
            for(int j=1;j<=n;j++){
                int rodLength = i+1;
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(rodLength<=j){
                    take = price[i] +dp[i][j-rodLength];
                }
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[n-1][n];
    }

    public static int spaceOpti(int[] price,int n){
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++) dp[i] = i* price[0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int rodLength = i+1;
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if(rodLength<=j){
                    take = price[i] + dp[j-rodLength];
                }
                dp[j] = Math.max(notTake,take);
            }
        }
        return dp[n];
    }
}
