package Year2023.Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC131 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        recur(temp,res,0,s,generatePalindrome(s));
        return res;
    }

    public static void recur(List<String> temp,List<List<String>> result, int idx,String s,boolean[][] dp){
        if(idx==s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(dp[idx][i]){
                temp.add(s.substring(idx,i+1));
                recur(temp,result,i+1,s,dp);
                temp.remove(temp.size()-1);
            }
        }

    }

    public static boolean[][] generatePalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])){
                   dp[j][i] = true;
                }
            }
        }
        return dp;
    }
}
