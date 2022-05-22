package LeetCodeChallenge.MAY2022;

import java.nio.charset.StandardCharsets;

public class LC647PalindromicSubstring {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count =0;
        for(int len = 1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j= i+len-1;
                //case where we find equals
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j || i+1==j){
                        dp[i][j] =1;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}
