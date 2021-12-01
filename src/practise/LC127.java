package practise;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 10:45 PM 12/1/2021
 */
public class LC127 {

    public static void main(String[] args) {
    List<String> wordList = Arrays.asList("a","b","c");
        System.out.println(ladderLength("a","c",wordList));
//        System.out.println("hit".substring(1,3));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String word = q.poll();
                if(word.equals(endWord)) return depth;
                for(int i=0;i<word.length();i++){
                    char [] chars = word.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        chars[i] =ch;
                        String newWord = new String(chars);
                        if(set.contains(newWord)){
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }

            depth++;
        }
        return 0;
    }


}
