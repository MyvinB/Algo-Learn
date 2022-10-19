package LeetCodeChallenge.Oct2022.Daily;

import java.util.*;

public class LC692 {

    public static void main(String[] args) {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words,2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        /**
         * Doing the reverse of what we have to do to maintain a klogn size heap size.
         * */
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(map.get(a)==map.get(b)){
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);
        });
        for(String p:map.keySet()){
                pq.offer(p);
                if(pq.size()>k) pq.poll();
        }
        List<String> res = new ArrayList<>();
        while(k--!=0){
            res.add(0,pq.poll());
        }
        return res;
    }
}
