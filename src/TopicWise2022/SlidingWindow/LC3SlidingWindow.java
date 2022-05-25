package TopicWise2022.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC3SlidingWindow {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(),max=0,start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)>=start){
                    start = map.get(ch)+1;
                }
            }
            map.put(ch,i);
            max = Math.max(i-start+1,max);
        }
        return max;
    }
}
