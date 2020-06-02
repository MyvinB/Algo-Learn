package LeetCode.DP;
/*
 @author Myvin Barboza
 02/06/20 3:38 PM 
 */

public class LC72EditDistance {

    static int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<=n;i++) dp[i][0]=1+dp[i-1][0];
        for(int j=1;j<=m;j++) dp[0][j]=1+dp[0][j-1];

        for(int i=1;i<=n;i++)
            for (int j = 1; j <=m ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));

                }
            }
    return dp[n][m];
    }



    public static void main(String[] args) {
    String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
}