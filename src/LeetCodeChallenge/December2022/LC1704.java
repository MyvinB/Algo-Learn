package LeetCodeChallenge.December2022;

import java.util.Arrays;
import java.util.HashSet;

public class LC1704 {

    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int lo = 0;
        int hi = s.length()-1;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while(lo<hi){
            if(set.contains(s.charAt(lo++)))leftCount++;
            if(set.contains(s.charAt(hi--)))rightCount++;
        }
        return leftCount==rightCount?true:false;
    }
}
