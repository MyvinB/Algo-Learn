package practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 4:30 PM 11/27/2021
 */
public class LC238 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(a));
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        //1 2 3 4
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int right =1;
        for(int i=nums.length-1 ;i>=0;i--){
            res[i] *=right;
            right *= nums[i];

        }
//        product =1;
// 1 2 3 4
// 1 2 6 24
//
//        for(int i=nums.length-2 ;i>0;i--){
//            product = product * nums[i+1];
//            res[i]= res[i-1] * product;
//        }
//        res[nums.length-1] = res[i]
        System.out.println(Arrays.toString(res));
        return res;

    }
}
