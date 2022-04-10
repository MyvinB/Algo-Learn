package LeetCodeChallenge.APR2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 7:58 AM 4/9/2022
 * Time Taken:
 */
public class LC347 {

    public static void main(String[] args) {

    }
    //nlogk
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int i : map.keySet()) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        k = k - 1;
        while (!pq.isEmpty() && k >= 0) {
            ans[k--] = pq.poll();
        }
        return ans;
    }


    public int[] topKFrequentBucket(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        for (int i : map.keySet()) {
            int freq = map.get(i);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for(int i=n;i>=0 && res.size()<k;i--){
            if(bucket[i]!=null){
                res.addAll(bucket[i]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }


}
