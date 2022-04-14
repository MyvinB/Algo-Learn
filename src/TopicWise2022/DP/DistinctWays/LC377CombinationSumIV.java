package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 10:19 AM 4/14/2022
 * Time Taken:
 */
public class LC377CombinationSumIV {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3};
        System.out.println(combinationSum4(t,4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int i=1;i<=target;i++){
            for(int j=0;j<n;j++){
                if(i-nums[j]>=0){
                  dp[i] += dp[i-nums[j]] +1;
                }
            }
        }
        return dp[target];
    }
}
