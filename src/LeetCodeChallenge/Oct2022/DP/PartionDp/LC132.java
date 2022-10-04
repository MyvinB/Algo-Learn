package LeetCodeChallenge.Oct2022.DP.PartionDp;

import java.util.Locale;

public class LC132 {

    public static void main(String[] args) {
        String t = "ab";
        System.out.println(minCut(t));
    }


    public static int minCut(String s) {

        int n = s.length();
        int[][] isPalindrome = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && ((i-j)<=2 || isPalindrome[j+1][i-1]==1) ){
                    isPalindrome[j][i] = 1;
                }
            }
        }
        int[] dp = new int[n];
        for(int i=0;i<dp.length;i++) dp[i] = -1;
        return recurMemo(s,0,isPalindrome,dp);

    }

    public static int recurMemo(String s , int i,int[][] isPalindrome, int[]dp ){
        //Base case
        if(i==s.length()-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            //We reach last index no need to count partion whole thing from i to j is one partion and last partion is not counted
            if(isPalindrome[i][j]==1 && j==s.length()-1){
                min = 0;
            }
            else if(isPalindrome[i][j]==1){
               int  partion = 1 + recurMemo(s,j+1,isPalindrome,dp);
               min = Math.min(min,partion);
            }

        }
        return dp[i]=min;
    }
}
//a a a
//a a | b |