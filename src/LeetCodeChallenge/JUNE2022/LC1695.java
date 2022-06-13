package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC1695 {

    public static void main(String[] args) {
        int[] t = new int[]{5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(t));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int i = 0,j=0,sum=0,max=0,n = nums.length;
        Set<Integer> set = new HashSet<>();
        while(i<n && j<n){
            if(!set.contains(nums[j])){
                sum+= nums[j];
                max = Math.max(max,sum);
                set.add(nums[j++]);
            }else{
                sum-=nums[i];
                set.remove(nums[i++]);
            }
        }
        return max;
    }
}
