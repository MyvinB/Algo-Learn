package Contest.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Contest3July {

    public static void main(String[] args) {
      String p=  "the quick brown fox jumps over the lazy dog";
       String v =  "vkbs bs t suepuv";
        System.out.println((char)97);
        System.out.println( decodeMessage(p,v));
    }


    public static String decodeMessage(String key, String message) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int t = 65;
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(ch==' ') continue;
            if(set.contains(ch)) continue;
            map.put(ch,(char)t);
            t++;
            set.add(ch);
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' ') sb.append(' ');
            else
                sb.append(Character.toLowerCase(map.get(message.charAt(i))));
        }
        return sb.toString();
    }
}
