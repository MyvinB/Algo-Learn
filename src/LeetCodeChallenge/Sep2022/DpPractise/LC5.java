package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC5 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeI("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]= 1;
        int max = 1;
        int stI = 0;
        for(int k=2;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(k==2){
                        dp[i][j] = 1;
                        max = 2;
                        stI = i;
                    }else{
                        if(dp[i+1][j-1]==1){
                            stI = i;
                            dp[i][j] = 1;
                            max = Math.max(max,k);
                        }
                    }

                }
            }
        }
        return s.substring(stI,stI+max);
    }

    //Fail case only applicable on subsequence for example take "aacabdkacaa" and you would understand why well we learn through experimenting
    public  static String longestPalindromeI(String s){
        int n = s.length();
        int m = n;
        String s1  = new StringBuilder(s).reverse().toString();
        int[][] dp=new int[n+1][m+1];
        int ans = 0;
        int endI = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    int val = 1 + dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(ans,val);
                    if(ans==dp[i][j]) endI = i-1;
                }
                else
                    dp[i][j] = 0;
            }
        }
        //Considering one index already considered
        ans = ans -1;
        //Remember substring is exclusive at end index and inclusive at start index
        System.out.println(Arrays.deepToString(dp));
        System.out.println(endI +" "+ans);
        return s.substring(endI-ans,endI+1);

    }

}
