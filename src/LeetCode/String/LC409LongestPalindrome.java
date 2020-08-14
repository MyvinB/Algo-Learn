package LeetCode.String;/*
 @author Myvin Barboza
 14/08/20 3:19 PM 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC409LongestPalindrome {


    public int longestPalindrome(String s) {
        TreeMap<Character,Integer> map=new TreeMap();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        Character mid=null;
        StringBuilder sb=new StringBuilder();
        for(char ch:map.keySet()){

            if(map.get(ch)%2==1){
                mid=ch;
            }
            for(int i=0;i<map.get(ch)/2;i++){
                sb.append(ch);
            }
        }
        int midVal=mid==null?0:1;
        return sb.length()*2+midVal;


    }

    public static void main(String[] args) {

    }



}
