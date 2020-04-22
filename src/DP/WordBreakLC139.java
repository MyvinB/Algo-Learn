package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 @author Myvin Barboza
 21/04/20 12:42 PM 
 */
public class WordBreakLC139 {

    static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>  set=new HashSet<>();
        for(String p: wordDict){
            set.add(p);
        }
        return dfs(s,set);
    }

    static boolean dfs(String s, HashSet<String> set){
        if(s.length()==0) return true;
        for (int i = 1; i <s.length() ; i++) {
                if(set.contains(s.substring(0,1)) &&
                dfs(s.substring(i,s.length()),set)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("cats");
        list.add("dog");
//        list.add("sand");
//        list.add("and");
//        list.add("cats");
        System.out.println(wordBreak("catsdog",list));
    }
}