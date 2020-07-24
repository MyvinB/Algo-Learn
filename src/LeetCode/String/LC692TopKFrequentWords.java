package LeetCode.String;/*
 @author Myvin Barboza
 24/07/20 9:08 PM 
 */

import java.util.*;

public class LC692TopKFrequentWords {
    //time nlogk space o(n)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s: words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //minheapgit
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->(
                map.get(a)==map.get(b)?b.compareTo(a):map.get(a)-map.get(b)

        ));
        // Doing this nlogn complexity lets make it k
        //pq.addAll(map.keySet());
        for(String s: map.keySet()){
            pq.offer(s);
            if(pq.size()>k)pq.poll();

        }
        //used for the o(1) insertion time
        List<String> list=new LinkedList<>();
        while(k--!=0){
            list.add(0,pq.poll());

        }
        return list;
    }

}
