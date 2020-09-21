package LeetCode.BitWiseAlgo;

import java.util.HashSet;
import java.util.Set;

public class LC421MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {
        int nums[]={3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }

    static  int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 4; i >= 0; i--){
            System.out.println(Integer.toBinaryString(mask));
            mask = mask | (1 << i);
            System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
