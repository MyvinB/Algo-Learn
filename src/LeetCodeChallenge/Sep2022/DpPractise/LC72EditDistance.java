package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC72EditDistance {

    public static void main(String[] args) {
        System.out.println(tabulation("","a"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] d:dp) Arrays.fill(d,-1);
        int ans = recurMemo(word1,word1.length()-1,word2,word2.length()-1,dp);
        if(ans==(int)Math.pow(10,9)) return 0;
        else return ans;
    }
    //    Insert a character
//    Delete a character
//    Replace a character
//    ""
//            "a"
    public static int recurMemo(String word1,int i,String word2, int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];
        //Happy case
        if(word1.charAt(i)==word2.charAt(j)){
            return recurMemo(word1,i-1,word2,j-1,dp);
        }
        //deletion addition and replace
        else {
            int insert = 1+recurMemo(word1,i,word2,j-1,dp);
            int delete = 1+recurMemo(word1,i-1,word2,j,dp);
            int replace = 1+recurMemo(word1,i-1,word2,j-1,dp);
            return Math.min(Math.min(insert,delete),replace);
        }
    }


    public static int tabulation(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]= i;
        for(int j=0;j<=m;j++) dp[0][j] = j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }


}
