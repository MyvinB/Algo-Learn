package LeetCodeChallenge.JULY2021;

public class LC915 {


    public int partionDisjoint(int[] nums){
        int maxUntilI = nums[0];
        int maxInLeftPortion = nums[0];
        int partionId = 0;
        for( int i=1; i<nums.length; i++){
            maxUntilI = Math.max(maxUntilI,nums[i]);
            if(nums[i]<maxInLeftPortion){
                maxInLeftPortion = maxUntilI;
                partionId =i;
            }
        }
        return partionId+1;

    }

    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            leftMax[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            rightMin[i] = min;
        }
        for (int i = 1; i < nums.length; i++) {
            if (leftMax[i - 1] <= rightMin[i]) {
                return i;
            }
        }
        return 0;
    }


}
