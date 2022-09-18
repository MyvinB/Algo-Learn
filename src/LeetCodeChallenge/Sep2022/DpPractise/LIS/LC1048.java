package LeetCodeChallenge.Sep2022.DpPractise.LIS;

import java.util.Arrays;

public class LC1048 {

    public static void main(String[] args) {
        String[] t = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(t));
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max  = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && (dp[j]+1)>dp[i]){
                    dp[i] = 1+ dp[j];
                }
            }
            if(dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static boolean compare(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int f=0,s=0;
        System.out.println(s1+" "+s2);
        while(f<s1.length()){
            if(s<s2.length() && s1.charAt(f)==s2.charAt(s)) {
                f++;s++;
            }else f++;
        }
        if(f==s1.length() && s==s2.length()) return true;
        else return false;
    }
}
