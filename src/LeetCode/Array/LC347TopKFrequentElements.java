package LeetCode.Array;/*
 @author Myvin Barboza
 18/07/20 10:21 AM 
 */

import java.util.*;

public class LC347TopKFrequentElements {

    public static void main(String[] args) {
       int a[]={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(a,2)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        List<Integer> list=new ArrayList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int a:set)pq.offer(a);
        while(k--!=0){
            list.add(pq.poll());
        }


        return list.stream().mapToInt(i -> i).toArray();
    }
}
