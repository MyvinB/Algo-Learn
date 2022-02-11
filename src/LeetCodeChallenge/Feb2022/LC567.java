package LeetCodeChallenge.Feb2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 9:54 AM 2/11/2022
 * Time Taken:
 */
public class LC567 {

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1,s2));
    }

    //Using sliding windows pattern
    public static boolean checkInclusion(String s1, String s2) {
       int end=0,begin=0;
       HashMap<Character,Integer> map = new HashMap<>();
       for(char c:s1.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
       }
       int counter = map.keySet().size();
       while(end<s2.length()){
           char cur = s2.charAt(end);
           if(map.containsKey(cur)){
               map.put(cur,map.get(cur)-1);
               if(map.get(cur)==0) counter--;
           }
           end++;
           //We found the window
           while(counter==0){
               char st = s2.charAt(begin);
               //Updating the window
               if(map.containsKey(st)){
                   map.put(st,map.get(st)+1);
                   if(map.get(st)>0) counter++;
               }
               if(end-begin==s1.length()){
                   return true;
               }
               begin++;
           }
       }
       return false;
    }
}
