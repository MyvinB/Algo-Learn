package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 3:10 PM 11/29/2021
 */
public class LC49 {

    public static void main(String[] args) {
       String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
       groupAnagrams(strings);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s:strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String toCheck =Arrays.toString(temp);
            List<String> tempList;
            if(map.containsKey(toCheck)){
                tempList = map.get(toCheck);
            }
            else tempList = new ArrayList<>();
            tempList.add(s);
            map.put(toCheck,tempList);
        }
        for(String s:map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
