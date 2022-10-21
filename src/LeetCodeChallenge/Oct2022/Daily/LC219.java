package LeetCodeChallenge.Oct2022.Daily;

import java.util.HashMap;

public class LC219 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(t,2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if((i+1)-map.get(nums[i])<=k) return true;
            }
            map.put(nums[i],i+1);
        }
        return false;
    }

}
