package LeetCodeChallenge.MAY2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LC1679 {

    public static void main(String[] args) {
        int[] t = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        System.out.println(maxOperations(t,k));
    }

    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i]) && map.get(k-nums[i])>0){
                count++;
                map.put(k-nums[i],map.get(k-nums[i])-1);
            }
            else {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}
