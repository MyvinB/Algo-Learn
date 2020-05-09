package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 24/04/20 8:35 AM 
 */public class ThreeSumClosetLC16 {
//  [-4,-1,1,2]
    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[nums.length-1];
        for (int i = 0; i < nums.length-2 ; i++) {
            int low=i+1;
            int high=nums.length-1;
                while(low<high){
                int sum=nums[low]+nums[high]+nums[i];
                if(sum>target)high--;
                if(sum<=target)low++;
                if(Math.abs(sum-target)<Math.abs(result-target))result=sum;
            }
        }
        return result;

    }



     public static void main(String[] args) {
        int nums[]={0,1,2};
         System.out.println(threeSumClosest(nums,3));
    }
}