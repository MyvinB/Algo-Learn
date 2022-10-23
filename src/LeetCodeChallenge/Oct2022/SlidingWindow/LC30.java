package LeetCodeChallenge.Oct2022.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30 {

    public static void main(String[] args) {
        String word ="wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(findSubstring(word,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String w:words) map.put(w,map.getOrDefault(w,0)+1);
        List<Integer> res = new ArrayList<>();
        int len = words[0].length();
        for(int i=0;i<=s.length()-len*words.length;i++){
            HashMap<String,Integer> copyMap = new HashMap<>(map);
            for(int j=0;j<words.length;j++){
                String word = s.substring(i+j*len,i+j*len+len);
                if(copyMap.containsKey(word)){
                    int count = copyMap.get(word);
                    if(count==1) copyMap.remove(word);
                    else copyMap.put(word,count-1);
                    if(copyMap.isEmpty()){
                        res.add(i);
                        break;
                    }
                }else break;
            }
        }
        return res;
    }
}
