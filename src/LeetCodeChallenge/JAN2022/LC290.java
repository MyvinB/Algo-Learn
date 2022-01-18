package LeetCodeChallenge.JAN2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 12:26 PM 1/18/2022
 */
public class LC290 {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog cat dog";
        System.out.println(wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern, String str) {
        String word[]=str.split(" ");
        if(word.length!=pattern.length()) return false;

        HashMap map=new HashMap<>();

        for(Integer i=0;i<word.length;i++){
            if(map.put(pattern.charAt(i),i)!=map.put(word[i],i))
                return false;
        }
        return true;
    }
}
