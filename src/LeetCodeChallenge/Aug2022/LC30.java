package LeetCodeChallenge.Aug2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30 {

    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> freqMap = new HashMap();
        int num = words.length, len = words[0].length();
        for(String word:words) freqMap.put(word, freqMap.getOrDefault(word,0));
        for(int i=0;i<s.length()-num*len;i++){
            HashMap<String,Integer> copyMap = new HashMap(freqMap);
            for(int j=0;j< words.length;j++){
                String str = s.substring(i+j*len,i+j*len+len);
                if(copyMap.containsKey(str)){
                    int count = copyMap.get(str);
                    if(count==1) copyMap.remove(str);
                    else copyMap.put(str,count-1);
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
