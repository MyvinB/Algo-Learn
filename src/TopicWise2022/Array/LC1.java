package TopicWise2022.Array;

import java.util.HashMap;

public class LC1 {

    public int[] twoSumMap(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]-target)){
                return new int[]{map.get(nums[i]-target),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }





}
