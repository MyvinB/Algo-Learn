package Company.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:55 AM 3/13/2022
 * Time Taken:
 */
public class LC140WordBreakII {

    public static void main(String[] args) {
        //Do not use static while passing testcases will be one map and will give wrong answer

        String s = "a";
        String[] ar = {"b","cats","and","sand","dog"};
        System.out.println(wordBreak(s, Arrays.asList(ar)));
    }

    public static HashMap<String,List<String>> map=new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
      List<String> res = new ArrayList<>();
      if(s==null || s.length() == 0)
            return res;
      if(map.containsKey(s)) return map.get(s);
      if(wordDict.contains(s)) res.add(s);

      for(int i=1;i<s.length();i++){
          String t = s.substring(i);
          if(wordDict.contains(t)){
              List<String> temp = wordBreak(s.substring(0,i),wordDict);
              if(temp!=null){
                  for(int j=0;j<temp.size();j++){
                      res.add(temp.get(j) +" "+t);
                  }
              }
          }
      }
      map.put(s,res);
      return res;
    }
}
