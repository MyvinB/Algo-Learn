package Year2024.Feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC49 {

    public static void main(String[] args) {
        String[] t ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(t));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] t = new char[26];
            for(int i=0;i<s.length();i++){
                t[s.charAt(i)-'a']++;
            }
            String key = String.valueOf(t);
            System.out.println(key);
            List<String> temp=map.getOrDefault(key,new ArrayList<>());
            temp.add(s);
            map.put(key,temp);
        }
        System.out.println(map.values());
        return new ArrayList<>( map.values());
    }
}
