package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 {

    public static void main(String[] args) {

    }

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int start = 0;
        int end = 10;
        while(end<=s.length()){
            String t = s.substring(start,end);
            if(set.contains(t)) repeated.add(t);
            set.add(t);
            start++;
            end++;
        }
        return new ArrayList<>(repeated);
    }
}
