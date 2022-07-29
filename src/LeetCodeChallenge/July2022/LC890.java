package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC890 {

    public static void main(String[] args) {
       // "abb"
        System.out.println(Arrays.toString(findPattern("baba")));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] toGet = findPattern(pattern);
        for(String word:words){
            if(Arrays.equals(toGet,findPattern(word))){
                res.add(word);
            }
        }
        return res;
    }

    public static int[] findPattern(String pattern){
        int n = pattern.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            char ch = pattern.charAt(i);
            map.putIfAbsent(ch,map.size());
            res[i] = map.get(ch);
        }
        return res;
    }
}
