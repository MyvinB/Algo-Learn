package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.List;

public class LC916WordSubset {

    public static void main(String[] args) {
//        ["amazon","apple","facebook","google","leetcode"]
//        ["lo","eo"]
        String[] s = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] p = new String[]{"lo","eo"};
        System.out.println(wordSubsets(s,p));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map = new int[128];
        for(String word:words2){
           int[] temp = getCharacterMap(word);
           for(int i=0;i<128;i++){
               map[i] = Math.max(map[i],temp[i]);
           }
        }
        List<String> res = new ArrayList<>();
        for(String word:words1){
            int[] temp = getCharacterMap(word);

            boolean isValid = false;
            for(int i=0;i<128;i++){
                if(temp[i]>=map[i]){
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }
            if(isValid) res.add(word);
        }
        return res;
    }

    static int[] getCharacterMap(String word){
        int[] map = new int[128];
        for(int i=0;i<word.length();i++){
            map[word.charAt(i)]++;
        }
        return map;
    }
}
