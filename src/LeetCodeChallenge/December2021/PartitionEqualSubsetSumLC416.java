package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 4:35 PM 12/12/2021
 */
public class PartitionEqualSubsetSumLC416 {
    /*
    0 1 2 3 4 5 6
  0 T F F F F F F
  1 T T F F F F F
  5 T T F F F T T
  4 T T F F T T F
  2 T T T T T T T

    * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        boolean dp[][] = new boolean[nums.length+1][sum/2+1];
        //Empty subset is true eg 5-5 = 0
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum/2];
    }
}
