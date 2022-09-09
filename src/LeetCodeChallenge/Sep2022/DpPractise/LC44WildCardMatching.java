package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC44WildCardMatching {

    public static void main(String[] args) {
        System.out.println(tabulation("bac","*a*"));
        System.out.println(tabulation("aab", "c*a*b"));


    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m][n];
        for(int[] d:dp) Arrays.fill(d,-1);
        return 1==recurMemo(s,s.length()-1,p,p.length()-1,dp);
    }

    public static int  recurMemo(String s,int i,String p,int j,int[][] dp){
        //base condition
        if(i<0 && j<0) return 1;
        if(i<0 ){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return 0;
            }
            return 1;
        }
        if(j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        //if we find * happy case

        //? matches one character
        //* matches all characters so if we get a star and everything before us matched we return true
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            return dp[i][j] = recurMemo(s, i - 1, p, j - 1,dp);
        }
        else if(p.charAt(j)=='*'){
            int takeStar = recurMemo(s,i-1,p,j,dp);
            int notTakeStar = recurMemo(s,i,p,j-1,dp);
            return takeStar==1||notTakeStar==1?1:0;
        }
        else return 0;
    }


    public static boolean tabulation(String s, String p){
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int j=1;j<=n;j++){
            int t = 1;
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    t=0;
                    break;
                }
            }
            if(p.charAt(j-1)=='*')dp[0][j] = t;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) ||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    int take = dp[i-1][j];
                    int noTake = dp[i][j-1];
                    dp[i][j] = take | noTake;
                }
            }
        }
        return dp[m][n]==1;
    }
}
