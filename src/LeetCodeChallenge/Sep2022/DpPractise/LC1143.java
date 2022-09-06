package LeetCodeChallenge.Sep2022.DpPractise;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class LC1143 {

    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int[]d :dp) Arrays.fill(d,-1);
        return recurMemo(text1,text2,n1-1,n2-1,dp);
    }

    public int recurMemo(String text1,String text2,int idx1,int idx2,int[][] dp){
        //Base case
        if(idx1 <0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            return 1 + recurMemo(text1,text2,idx1-1,idx2-1,dp);
        }
        //Assuming not equal
        return dp[idx1][idx2] =  Math.max(recurMemo(text1,text2,idx1-1,idx2,dp),recurMemo(text1,text2,idx1,idx2-1,dp));
    }

    public int tabulation(String text1,String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
