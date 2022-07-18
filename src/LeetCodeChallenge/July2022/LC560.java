package LeetCodeChallenge.July2022;

import java.util.HashMap;

public class LC560 {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0,1);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
