package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC238 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(t));
    }

    public static int[] productExceptSelf(int[] nums) {
        ///1,2,3,4
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res [i] = left * nums[i-1];
            left *= nums[i-1];
        }
        int right = 1;
        for(int i=n-1;i>=0;i--){
            res[i] *= right;
            right *= nums[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
