package Company.Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 2:22 PM 3/11/2022
 * Time Taken:
 */
public class LC139 {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] dict = new String[]{"cats","dog","sand","and","cat"};
        System.out.println(wordBreakDp(s, Arrays.asList(dict)));
    }
    //Using dfs and memo for saving depth calls
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreak(s,0,new int[s.length()],set);
    }

    public static boolean wordBreak(String s, int pos,int[] memo,HashSet<String> set){
        if(pos==s.length()) return true;
        if(memo[pos] ==1) return true;
        if(memo[pos] == 2) return false;
        StringBuilder sb = new StringBuilder(s);
        for(int i=pos+1;i<=s.length();i++){
            String str = sb.substring(pos,i);
            if(set.contains(str) && wordBreak(s,i,memo,set)){
                memo[pos] =1 ;
                return true;
            }
        }
        memo[pos] = 2;
        return false;
    }

    public static boolean wordBreakDp(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }



}
