package LeetCodeChallenge.MAY2022;

public class LC1480 {
    public int[] runningSum(int[] nums) {
        int preSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            preSum += nums[i];
            nums[i] = preSum;
        }
        return nums;
    }
}
