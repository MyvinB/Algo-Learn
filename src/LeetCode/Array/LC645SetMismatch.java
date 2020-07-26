package LeetCode.Array;/*
 @author Myvin Barboza
 26/07/20 8:49 AM 
 */

import java.util.Arrays;

public class LC645SetMismatch {
    public static void main(String[] args) {
       int nums[] = {2,2};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    static int[] findErrorNums(int[] nums) {
        //keeping an array to remember positons
        int res[]=new int[2];
        int a[]=new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            a[nums[i]]++;
            if(a[nums[i]]==2){
                res[0]=nums[i];
            }
        }
        for(int i=1;i<a.length;i++){
            if(a[i]==0){
                res[1]=i;
                break;
            }
        }
        return res;
    }
}
