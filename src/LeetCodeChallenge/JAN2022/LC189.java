package LeetCodeChallenge.JAN2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:33 PM 1/30/2022
 */
public class LC189 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,4,5,6,7};
        // 5,6,7,1,2,3,4
        // 1 2 3 4 5 6 7
        // 4 3 2 1 7 6 5
        // 5 6 7 1 2 3 4
        rotate(t,3);
        System.out.println(Arrays.toString(t));
    }

    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        int n=nums.length-1;
        reverse(nums,0,n-k);
        reverse(nums,n-k+1,n);
        reverse(nums,0,n);
    }
    private static void reverse(int nums[],int low,int high){
        while(low<high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high]=temp;
            low++;high--;
        }
    }
}
