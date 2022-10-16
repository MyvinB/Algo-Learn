package LeetCodeChallenge.Oct2022.DP.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC140 {

    public static void main(String[] args) {

    }
    HashMap<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(map.containsKey(s)) return map.get(s);
        if(wordDict.contains(s)) res.add(s);
        for(int i=1;i<s.length();i++){
            String t = s.substring(i);
            if(wordDict.contains(t)){
                List<String> temp = wordBreak(s.substring(0,i),wordDict);
                for(int k=0;k<temp.size();k++){
                    res.add(temp.get(k)+" "+t);
                }
            }
        }
        map.put(s,res);
        return res;
    }

}
