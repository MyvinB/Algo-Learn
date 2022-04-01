package TopicWise2022.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 2:59 PM 4/1/2022
 * Time Taken:
 */
public class LC140 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        wordBreak(s,wordDict);
    }


    public static HashMap<String,List<String>> map=new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s==null || s.length()==0) return res;
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
