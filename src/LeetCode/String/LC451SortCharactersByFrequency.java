package LeetCode.String;
/*
 @author Myvin Barboza
 23/05/20 11:06 AM 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC451SortCharactersByFrequency {

    static String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(key1,key2)->map.get(key2)-map.get(key1));
        StringBuilder sb=new StringBuilder();
        for(Character c:list){
            int count=map.get(c);
            while(count--!=0)sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}