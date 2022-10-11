package LeetCodeChallenge.Oct2022.Daily;

import java.util.Arrays;

public class LC334 {

    public static void main(String[] args) {
        //[20,100,10,12,5,13]
        int[] t = new int[]{20,100,10,12,5,13};
        System.out.println(increasingTriplet(t));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=first){
                first = nums[i];
            }else if(nums[i]<=second){
                second = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
