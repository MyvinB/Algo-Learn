package LeetCode.DP;/*
 @author Myvin Barboza
 28/06/20 10:32 AM 
 */

import java.util.Arrays;

public class LC279PerfectSquares {


    public static void main(String[] args) {
        System.out.println(numSquares(1));
    }
    //dp complexity n* root(n)
    static int numSquares(int n) {
        int dp[]=new int[n+1];
        dp[0]=0; dp[1]=1;

        for (int i = 2; i <=n; i++) {
            dp[i]=i;
            for (int j =1 ; j*j <=i ; j++) {
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);

            }
        }
        return dp[n];

    }


    //need to use memonization this is the recursive way calulating all the squares for each possible sum
    static int ans=Integer.MAX_VALUE;
    static int recur(int N){
        if(N<=3) return N;
        for(int i=1;i*i<=N;i++)
         ans=Math.min(ans,1+recur(N-i*i));
        return ans;
    }


}
