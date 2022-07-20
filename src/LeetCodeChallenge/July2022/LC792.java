package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC792 {

    public static void main(String[] args) {
        String s= "dsahjpjauf";
        String[] words = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s,words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, Queue<String>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.putIfAbsent(s.charAt(i),new LinkedList<>());
        }
        for(String w:words){
           if(map.containsKey(w.charAt(0))){
              map.get(w.charAt(0)).add(w);
            }
        }
        int ans = 0;
        for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                Queue<String> temp = map.get(ch);
                int size = temp.size();
                for(int k=0;k<size;k++){
                    String p = temp.poll();
                    if(p.substring(1).length()==0){
                        ans++;
                    }else {
                        if(map.containsKey(p.charAt(1))){
                            map.get(p.charAt(1)).add(p.substring(1));
                        }
                    }
                }
            }
        return ans;
    }
}
