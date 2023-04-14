package Year2023.Apr;

import java.util.Arrays;

public class LC1143 {

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(tabulation("abcde","ace"));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
       return recurMemo(text1,n-1,text2,m-1,dp);
    }

    public static int recurMemo(String text1,int i,String text2,int j,int[][] dp){
        if(i<0 ||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j] = 1+recurMemo(text1,i-1,text2,j-1,dp);
        }
        else return dp[i][j] = Math.max(recurMemo(text1,i-1,text2,j,dp),recurMemo(text1,i,text2,j-1,dp));
    }

    public static int tabulation(String text1,String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
