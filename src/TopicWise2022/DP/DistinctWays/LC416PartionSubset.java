package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 10:47 AM 4/14/2022
 * Time Taken:
 */
public class LC416PartionSubset {

    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+= nums[i];
        if(sum%2!=0) return false;
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=sum;j>=0;j--){
                if(j>=nums[i-1])
                    dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[sum];
    }
}
