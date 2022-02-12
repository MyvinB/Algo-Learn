package LeetCodeChallenge.Feb2022;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 5:04 PM 2/12/2022
 * Time Taken:
 */
public class LC127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.poll();
                if(word.equals(endWord)) return count;
                for(int j=0;j<word.length();j++){
                    for(int k='a';k<='z';k++){
                        char[] wordAr = word.toCharArray();
                        wordAr[j] = (char)k;
                        String s = new String(wordAr);
                        if(set.contains(s) && !visited.contains(s)){
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }
}
