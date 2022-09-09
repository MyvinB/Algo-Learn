package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class DP32 {

    public static void main(String[] args) {
//        System.out.println(numDistinct("babgbag","bag"));
//        System.out.println(tabulation("babgbag","bag"));
        System.out.println(spaceOpti("babgbag","bag"));

    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int n1 = t.length();
        int[][] dp = new int[n1][n];
        System.out.println(Arrays.deepToString(dp));
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(s,n-1,t,n1-1,dp);
    }


    public static int recurMemo(String s,int j, String t,int i, int[][] dp){
        //We manage to finsih compare string
        if(i<0) return 1;
        //We finished our compare string but still did not find match
        if(j<0) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        if(s.charAt(j)==t.charAt(i)){
            //taking the char and not taking the char two way
            return dp[i][j] = recurMemo(s,j-1,t,i-1,dp) + recurMemo(s,j-1,t,i,dp);
        }else{
            return dp[i][j] =recurMemo(s,j-1,t,i,dp);
        }
    }

    public static int tabulation(String s,String t){
        int n = s.length();
        int n1 = t.length();
        int[][] dp = new int[n+1][n1+1];
        for(int i =0;i<n;i++)dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n1];
    }

    public static int spaceOpti(String s,String t){
        int n = s.length();
        int n1 = t.length();
        int[] dp = new int[n1+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=n1;j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j] = dp[j-1]+dp[j];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n1];
    }



}
