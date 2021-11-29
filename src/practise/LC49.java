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
        HashMap<Integer,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String toCheck =Arrays.toString(temp);
            System.out.println(toCheck);
        }
        return null;
    }
}
