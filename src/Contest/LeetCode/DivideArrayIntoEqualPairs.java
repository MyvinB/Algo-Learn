package Contest.LeetCode;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 8:02 PM 3/19/2022
 * Time Taken:
 */
public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {

    }

    public boolean divideArray(int[] nums) {
        int n = nums.length;
        if(n%2!= 0) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int k:map.keySet()){
            if(map.get(k)!=0 && map.get(k)%2!=0) return false;
        }
        return true;
    }
}
