package DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 @author Myvin Barboza
 25/04/20 8:23 AM

 */
//leetcode
public class WordBreakLC139 {

    static boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];
        Set<String> set=new HashSet<String>();
        for(String word:wordDict)set.add(word);
        dp[0]=true;
        for (int i = 0; i <=s.length() ; i++) {
            for (int j = 0; j <i ; j++) {
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }


     public static void main(String[] args) {
        List<String> list= Arrays.asList("leet","code");
         System.out.println(wordBreak("leetcode",list));
    }
 }