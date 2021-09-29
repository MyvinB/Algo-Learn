package LeetCode.Array;

import java.util.Arrays;

public class LC922 {
    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i = i + 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j = j + 2;
            }
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }

        return nums;


    }

    public static void main(String[] args) {
        int a[]= new int[]{4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(a)));
    }

}
