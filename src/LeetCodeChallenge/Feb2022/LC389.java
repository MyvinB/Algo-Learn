package LeetCodeChallenge.Feb2022;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mmichaelbarboza
 * on 10:31 AM 2/7/2022
 * Time Taken:
 */
public class LC389 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcdt";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        int charCode  = t.charAt(t.length()-1);
        for(int i=0;i<s.length();i++){
            charCode+=s.charAt(i);
            charCode-=t.charAt(i);
        }

        return (char)charCode;
    }
}
