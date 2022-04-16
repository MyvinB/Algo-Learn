package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 6:54 PM 4/15/2022
 * Time Taken:
 */
public class LC494TargetSum {

    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        /*
         * sum(p) - sum(n) = d;
         * sum(p) +sum(n) +sum(p) - sum(n) = d+ sum(p)+sum(n)
         * 2 * sum(n) = d + totalSum
         * sum(n) = (d+totalSum)/2
         * to get sum(p) is should be exactly divisible
         * */
        int sum = 0;
        for(int i=0;i<nums.length;i++)sum+=nums[i];

        if(sum<target || (sum+target)%2>0) return 0;
        int sum1 = (sum+target)/2;
        sum1 = Math.abs(sum1);
        int[] dp = new int[sum1+1];
        dp[0] = 1;
        for(int i=1;i<=nums.length;i++){
            for(int j=sum1;j>=0;j--){
                if(j>=nums[i-1]){
                    dp[j] += dp[j-nums[i-1]];
                }
            }
        }
        return dp[sum1];
    }
}
