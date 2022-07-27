package LeetCodeChallenge.July2022;

import java.util.HashMap;

public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0,max=0;
        HashMap<Character,Integer>  map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //Assuming we see a chracter again we  find the last place it was there and start the string from there
            if(map.containsKey(ch)){
                if(map.get(ch)>=start){
                    start = map.get(ch)+1;
                }
            }
            map.put(ch,i);
            //+1 since zero index
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
