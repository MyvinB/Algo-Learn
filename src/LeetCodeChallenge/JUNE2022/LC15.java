package LeetCodeChallenge.JUNE2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

    public static void main(String[] args) {
        int[] p = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(p));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int k=0;k+2<n;k++){
            //Avoiding duplicates for k
            if(k>0 && nums[k]==nums[k-1]) continue;
            int lo = k+1, hi = n-1;
            int target = - nums[k];
            while(lo<hi){
                if((nums[lo]+nums[hi])==target){
                    res.add(Arrays.asList(nums[k],nums[lo],nums[hi]));
                    lo++;hi--;
                    //Avoiding duplicates when you find a match
                    while(lo<hi && nums[lo]==nums[lo-1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi+1]) hi--;
                }
                else if (nums[lo]+nums[hi]>target){
                    hi--;
                }
                else lo++;
            }
        }
        return res;
    }
}
