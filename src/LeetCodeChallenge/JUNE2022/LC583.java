package LeetCodeChallenge.JUNE2022;

public class LC583 {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(i==0||j==0) continue;
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int val = dp[n1][n2];
        return n1-val+n2-val;
    }
}
