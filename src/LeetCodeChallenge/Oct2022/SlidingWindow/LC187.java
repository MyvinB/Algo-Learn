package LeetCodeChallenge.Oct2022.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC187 {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static  List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        int start = 0, end = 10;
        while(end<=s.length()){
            String word = s.substring(start,end);
            if(set.contains(word)) repeated.add(word);
            set.add(word);
            start++;
            end++;
        }
        return new ArrayList<>(repeated);
    }
}
