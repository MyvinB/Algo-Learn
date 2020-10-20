package LeetCode.String;/*
 @author Myvin Barboza
 20/10/20 11:22 PM 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187RepeatedDNASequences {

    public static void main(String[] args) {
     String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    static List<String> findRepeatedDnaSequences(String s) {
       int start=0;
       int end=10;
       Set<String> set=new HashSet();
       Set<String> repeated=new HashSet();
       while(end<=s.length()){
           String temp=s.substring(start,end);
           if(set.contains(temp)){
               repeated.add(temp);
           }
           set.add(temp);
           start++;
           end++;
       }

       return new ArrayList<>(repeated);
    }
}
