package LeetCode.DP;/*
 @author Myvin Barboza
 30/07/20 4:51 PM 
 */

import java.util.*;

public class LC140WordBreakII {

    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        String s[]={"cat","cats","and","dog","sand"};
        set.addAll(Arrays.asList(s));
        List<String> list=wordBreak("catsanddog",set);
        System.out.println(list);
    }

    static HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res=new ArrayList<>();
        if(s==null || s.length() == 0)
            return res;
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(wordDict.contains(s)){
            res.add(s);
        }
        for(int i=1;i<s.length();i++){
            String t=s.substring(i);
            if(wordDict.contains(t)){
                List<String> temp=wordBreak(s.substring(0,i),wordDict);
                if(temp!=null){
                    for(int j=0;j<temp.size();j++){
                        res.add(temp.get(j)+" "+t);
                    }
                }
            }
        }
        map.put(s,res);
        return res;
    }

}
