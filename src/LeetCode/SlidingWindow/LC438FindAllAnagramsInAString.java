package LeetCode.SlidingWindow;
/*
 @author Myvin Barboza
 17/05/20 5:24 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC438FindAllAnagramsInAString {

    static List<Integer> findAnagrams(String s, String p) {
      List<Integer> list=new ArrayList<>();
      int hash[]=new int[26];
      int count=0;
      for(int i=0;i<p.length();i++)hash[p.charAt(i)-'a']++;
      int left=0;
      int right=0;
      count=p.length();

      while(right<s.length()){
          if(hash[s.charAt(right++)-'a']-->=1)count--;

          if(count==0) list.add(left);

          if(right-left==p.length() && hash[s.charAt(left++)-'a']++>=0) count++;
      }

      return list;
    }


    public static void main(String[] args) {

        String s="cbaebabacd";
        System.out.println(findAnagrams(s,"abc"));
    }
}