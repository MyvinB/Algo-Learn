package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 {


    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start = 0,end=0,counter=map.size();
        while(end<s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) counter--;
            }
            end++;
            while(counter==0){
                char chS = s.charAt(start);
                if(map.containsKey(chS)){
                  map.put(chS,map.get(chS)+1);
                  if(map.get(chS)>0) counter++;
                }
                if(end-start==p.length()){
                    res.add(start);
                }
                start++;
            }
        }
        return res;
    }
}
