package LeetCodeChallenge.Nov2022.Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC433 {

    public static void main(String[] args) {

    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.stream(bank).toList());
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int count =1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String word = queue.poll();
                if(word.equals(end)) return count;
                for(int i=0;i<word.length();i++){
                    for(char t:new char[]{'A', 'C', 'G','T'}){
                        char[] wordAr = word.toCharArray();
                        wordAr[i] = t;
                        String tempWord = new String(wordAr);
                        if(set.contains(tempWord) && !visited.contains(tempWord)){
                            visited.add(tempWord);
                            queue.offer(tempWord);
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
