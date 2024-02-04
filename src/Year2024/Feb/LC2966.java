package Year2024.Feb;

import java.util.Arrays;

public class LC2966 {


    public static void main(String[] args) {

    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int t = nums.length/3;
        int[][] res = new int[t][3];
        for(int i =2 ;i<nums.length;i=i+2){
            if(nums[i]-nums[i-2]>k) return new int[0][];
            res[i/3] = new int[]{nums[i-2],nums[i-1],nums[i]};
        }
        return res;
    }

}
