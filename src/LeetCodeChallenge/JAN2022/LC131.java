package LeetCodeChallenge.JAN2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 7:52 AM 1/5/2022
 */
public class LC131 {
    public static void main(String[] args) {
        String s= "egff";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }
            }
        }
        dfs(s,0,new ArrayList<>(),res,dp);
        return res;
    }

    public static void dfs(String s, int pos, List<String> temp, List<List<String>> res,boolean dp[][]){
        if(pos==s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=pos;i<s.length();i++){
            if(dp[pos][i]){
                temp.add(s.substring(pos,i+1));
                dfs(s,i+1,temp,res,dp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s,int low,int high){
        while(low<high)if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
}
