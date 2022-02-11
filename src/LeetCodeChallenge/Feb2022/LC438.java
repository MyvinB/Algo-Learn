package LeetCodeChallenge.Feb2022;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:43 AM 2/2/2022
 * Time Taken:
 */
public class LC438 {
    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
    //Intution sliding window pattern
    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> res = new ArrayList<>();
        if(t.length()>s.length()) return res;
        int begin=0,end=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //not t.length becase consider aaa
        int counter = map.size();

        while(end<s.length()){
            char cur = s.charAt(end);
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)-1);
                if(map.get(cur)==0)counter--;
            }
            end++;
            while(counter==0){
                char st = s.charAt(begin);
                if(map.containsKey(st)){
                    map.put(st,map.get(st)+1);
                    if(map.get(st)>0){
                        counter++;
                    }
                }
                if(end-begin==t.length()){
                    res.add(begin);
                }
                begin++;
            }

        }
        return res;
    }



}
