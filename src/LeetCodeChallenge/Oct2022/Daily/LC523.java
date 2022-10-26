package LeetCodeChallenge.Oct2022.Daily;

import java.util.HashMap;

public class LC523 {

    public static void main(String[] args) {

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            if(k!=0) preSum=preSum%k;
            if(map.containsKey(preSum)){
                if(i-map.get(preSum)>=2) return true;
            }
            else map.put(preSum,i);
        }
        return false;
    }
}
