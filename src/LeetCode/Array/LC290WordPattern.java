package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class LC290WordPattern {

    public static void main(String[] args) {
        String pattern="abbd";
        String val="ankita reshma reshma ankita";
        System.out.println(wordPattern(pattern,val));

    }

     static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
         //use Integer
         //for more details https://stackoverflow.com/questions/3130311/weird-integer-boxing-in-java
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
