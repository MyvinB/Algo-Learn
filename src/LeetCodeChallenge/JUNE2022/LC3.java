package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;

public class LC3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(),max=0,start=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(map.get(cur)>=start)
                    start = map.get(cur)+1;
            }
            map.put(cur,i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
