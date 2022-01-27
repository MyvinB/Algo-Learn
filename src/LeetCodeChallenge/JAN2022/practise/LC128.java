package LeetCodeChallenge.JAN2022.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 9:29 AM 1/27/2022
 */
public class LC128 {
    public static void main(String[] args) {
        int[] t = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(t));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(!set.contains(num-1)){
                int count=0;
                while(set.contains(num++)){
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;

    }
}
