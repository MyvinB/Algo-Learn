package LeetCodeChallenge.JULY2021;

import java.util.Arrays;

public class LC611 {

    public static void main(String[] args) {
        triangleNumber(new int[]{2,4,9,10,11});
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            int low = 0;
            int high = i - 1;
            while(low<high){
                if (nums[low] + nums[high] > nums[i]) {
                    count += (high - low);
                    high--;
                }
                else low++;
            }

        }
        System.out.println(count);
        return count;
    }

}
