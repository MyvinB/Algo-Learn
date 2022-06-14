package LeetCodeChallenge.JUNE2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public static void main(String[] args) {
        int[] t = new int[]{2,2,2,2,2};
        System.out.println(fourSum(t,8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // We put it after the for loop atleast we need to process one unique result why it's not needed in two sum cause it's one elemnt only
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int k=0;k+3<n;k++){
            for(int l=k+1;l+2<n;l++){
                int toFind = target - nums[k] - nums[l];
                int lo = l+1;
                int hi = n-1;
                while(lo<hi){
                    if(nums[lo]+nums[hi]==toFind){
                        res.add(Arrays.asList(nums[k],nums[l],nums[lo],nums[hi]));
                        lo++;hi--;
                        while(lo<hi && nums[lo]==nums[lo-1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi+1]) hi--;
                    }
                    else if(nums[lo]+nums[hi]>toFind) hi--;
                    else lo++;
                }
                while(l+1<n && nums[l]==nums[l+1]) l++;
            }
            while(k+1<n && nums[k]==nums[k+1]) k++;
        }
        return res;
    }
}
