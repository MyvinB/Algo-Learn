package LeetCodeChallenge.July2022;

public class LC209 {

    public static void main(String[] args) {

    }


    public int minSubArrayLen(int target, int[] nums) {
        int lo=0,minLen = Integer.MAX_VALUE;
        int preSum = 0;
        for(int hi=0;hi<nums.length;hi++){
            preSum+=nums[hi];
            //Found an exceeding case lets shorten the window
            while(preSum>=target){
                minLen = Math.min(minLen,hi-lo+1);
                preSum -= nums[lo];
                lo++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
