package Year2023.Jan;

import java.util.HashMap;

public class LC974 {

    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] nums, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int rem = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            rem =preSum%K;
            count += map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;

    }
}
