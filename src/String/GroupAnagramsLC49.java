package String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 @author Myvin Barboza
 06/04/20 2:31 PM 
 */
public class GroupAnagramsLC49 {
    /*
    [
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
    */


    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();


        HashMap<String,List<String>> map= new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            String s=strs[i];
            char[] temp =s.toCharArray();
            Arrays.sort(temp);
            String sn=Arrays.toString(temp);

            if(map.containsKey(sn)){
                map.get(sn).add(s);
            }
            else{
                List<String> listString=new ArrayList<>();
                listString.add(s);
                map.put(sn,listString);

            }




        }

        for(String s: map.keySet()){
            list.add(map.get(s));
        }
        return list;
    }



    public static void main(String[] args) {
    String s[]={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }
}