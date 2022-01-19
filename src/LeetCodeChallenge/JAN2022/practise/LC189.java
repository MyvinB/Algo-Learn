package LeetCodeChallenge.JAN2022.practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 2:26 PM 1/19/2022
 */
public class LC189 {

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        int n = nums.length-1;
        reverse(nums,0,n-k);
        reverse(nums,n-k+1,n);
        reverse(nums,0,n);
    }

    public static void reverse(int[] nums,int start ,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
