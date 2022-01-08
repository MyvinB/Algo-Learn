package LeetCodeChallenge.JAN2022.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 5:49 PM 1/8/2022
 */
public class LC15 {

    public static void main(String[] args) {
        //Best example to understand internal loops
        int[] res = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(res));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i+2<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k] == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k] == nums[k+1])k--;
                }else if(nums[j]+nums[k]>target){
                    k--;
                }else j++;
            }
        }
        return res;
    }
}
