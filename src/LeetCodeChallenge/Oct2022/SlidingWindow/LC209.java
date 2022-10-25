package LeetCodeChallenge.Oct2022.SlidingWindow;

public class LC209 {

    public static void main(String[] args) {
        int[] t = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,t));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int lo = 0;int preSum = 0,minLen = Integer.MAX_VALUE;
        for(int hi=0;hi<nums.length;hi++){
            preSum += nums[hi];
            while(preSum>=target){
                minLen = Math.min(minLen,hi-lo+1);
                preSum -= nums[lo];
                lo++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }


}
