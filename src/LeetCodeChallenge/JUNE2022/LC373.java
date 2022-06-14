package LeetCodeChallenge.JUNE2022;

import Challenge.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC373 {

    public static void main(String[] args) {
        int[] t = new int[]{1,7,11};
        int[] p = new int[]{2,4,6};
        System.out.println(kSmallestPairs(t,p,3));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int sumA = a[0]+a[1];
            int sumB = b[0]+b[1];
            return sumA-sumB;
        });
        for(int i=0;i<nums1.length && i<k;i++) pq.offer(new int[]{nums1[i],nums2[0],0});
        while(k-->0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0],cur[1]));
            if(cur[2] == nums2.length-1) continue;
            pq.offer(new int[]{cur[0],nums2[cur[2]+1],cur[2]+1});
        }
        return res;
    }
}
