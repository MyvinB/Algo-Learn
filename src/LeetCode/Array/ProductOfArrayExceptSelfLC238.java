package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 15/04/20 6:50 PM 
 */
public class ProductOfArrayExceptSelfLC238 {

    //1234
    static int[] productExceptSelf(int[] nums) {
    int res[]=new int[nums.length];
    int t=1;
        for (int i = 0; i <nums.length ; i++) {
            res[i]=res[i]+t;
            t=t*nums[i];
        }
        t=1;
        for (int i = nums.length-1; i >=0 ; i--) {
            res[i]=res[i]*t;
            t=t*nums[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }


    public static void main(String[] args) {
    int nums[]={1,2,3,4};
    productExceptSelf(nums);
    }
}