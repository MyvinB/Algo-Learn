package TopicWise2022.Revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC140WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(wordBreak(s,wordDict));
    }

    public static HashMap<String,List<String>> map= new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if(map.containsKey(s)) return map.get(s);
        if(wordDict.contains(s)) res.add(s);
        for(int i=1;i<n;i++){
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
