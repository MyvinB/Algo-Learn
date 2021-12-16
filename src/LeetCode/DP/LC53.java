package LeetCode.DP;

/**
 * @author mmichaelbarboza
 * on 5:39 AM 12/16/2021
 */
public class LC53 {
    public static void main(String[] args) {
        int[] a = {-1,-2,-3,-4};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0], sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) sum = 0;
        }

        return max;
    }
}
