package TopicWise2022.Array;

public class LC209MinimumSizeSubarraySum {

    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int lo=0,sum=0,min=Integer.MAX_VALUE,n=nums.length;
        for(int hi=0;hi<n;hi++){
            sum+=nums[hi];
            while(sum>=target){
                min = Math.min(min,hi-lo+1);
                sum -= nums[lo];
                lo++;
            }

        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
