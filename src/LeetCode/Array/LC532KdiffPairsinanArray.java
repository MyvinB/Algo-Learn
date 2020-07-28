package LeetCode.Array;/*
 @author Myvin Barboza
 28/07/20 10:59 AM 
 */

import java.util.HashMap;

public class LC532KdiffPairsinanArray {
    public static void main(String[] args) {

        int ar[]={3,1,4,1,5};
        System.out.println(findPairs(ar,1));
    }

    static int findPairs(int[] nums, int k) {
        //absolute difference hence k<0 return
        if(nums.length==0||k<0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int key:map.keySet()){
            int val=map.get(key);
            if(k==0 && val==2)count++;
            else if(map.containsKey(key-k))count++;
        }
        return count;


    }

}
