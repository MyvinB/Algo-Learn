package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 8:59 AM 2/22/2022
 * Time Taken:
 */
public class LC53 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            maxSum = Math.max(maxSum,preSum);
            //If presum is - why have it in your subarray it would decrease its size
            if(preSum<0) preSum=0;
        }
        return maxSum;
    }
}
