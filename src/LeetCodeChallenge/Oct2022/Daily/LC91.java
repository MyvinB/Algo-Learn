package LeetCodeChallenge.Oct2022.Daily;

import java.util.Enumeration;

public class LC91 {

    public static void main(String[] args) {
        System.out.println(tabulation("226"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i =0;i<n;i++) dp[i] = -1;
        return recurMemo(s,0, dp);

    }


    public static int recurMemo(String s, int i, int[] dp){
        //26 letters so you can take two difit as one weway
        // we cannot process a single zero at the end so bye bye zero eg 20 no point as only number is 20 there cannot be 2 and then 0 as 0 cannot be decoded
        if(i==s.length()-1 &&s.charAt(i)=='0') return 0;
        if(i==s.length()-1 ||i==s.length()) return 1;

        if(dp[i]!=-1) return dp[i];
        int sum = 0;
        int f =  s.charAt(i)-'0';
        int g = s.charAt(i+1)-'0';
        if(f!=0)
            sum +=recurMemo(s,i+1,dp);
        //taking two digit
        int num = (f*10)+ g;
        if(num>=10 && num<=26 ){
            sum +=recurMemo(s,i+2,dp);
        }
        return dp[i] =sum;
    }


    public static int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        if(s.charAt(n-1)=='0') dp[n-1] = 0;
        else dp[n-1] = 1;
        dp[n] = 1;
        for(int i=n-2;i>=0;i--){
            int sum = 0;
            int f =  s.charAt(i)-'0';
            if(f!=0)
                dp[i] +=dp[i+1];
            int g = s.charAt(i+1)-'0';
            //taking two digit
            int num = (f*10)+ g;
            if(num>=10 && num<=26){
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
