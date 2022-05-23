package LeetCodeChallenge.MAY2022;

import java.util.Arrays;

public class LC474 {

    public static void main(String[] args) {
        String[] s = new String[]{"10","0001","111001","1","0"};
        findMaxForm(s,5,3);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        //Its a typical knapsack problem taking into current value find if there exist a possibility of that zero and one in the past only here we need to
        //find maximum subarray

        for(String s: strs){
            int z =0;
            int o = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') z++;
                else o++;
            }
            //Know that zero and one here are atmost and when we minus cannot go below their value or it will be in minus and give outof boudn error
            for(int i=m;i>=z;i--){
                for(int j=n;j>=o;j--){
                    dp[i][j] = Math.max(dp[i][j],1+dp[i-z][j-o]);
                }
            }
        }
        return dp[m][n];
    }
}
