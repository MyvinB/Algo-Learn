package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC1048 {

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int n =words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isLonger(words[i],words[j]) && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static boolean isLonger(String s,String p){
        if(s.length()!=p.length()+1) return false;
        int i=0,j=0;
        while(i<s.length()){
            if(j<p.length() && s.charAt(i)==p.charAt(j)){ i++;j++;}
            else i++;
        }
        if(s.length()==i && p.length()==j) return true;
        return false;
    }
}
