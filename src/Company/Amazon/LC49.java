package Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:41 AM 3/15/2022
 * Time Taken:
 */
public class LC49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"ac","c"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String t: strs){
            char[] ca = new char[26];
            for (char c : t.toCharArray()) ca[c - 'a']++;
            String key = String.valueOf(ca);
            List<String> temp;
            if(!map.containsKey(key)){
                temp = new ArrayList<>();
            }
            else temp = map.get(key);
            temp.add(t);
            map.put(key,temp);
        }

        return new ArrayList<>(map.values());
    }
}
