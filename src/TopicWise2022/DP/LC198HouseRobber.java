package TopicWise2022.DP;

/**
 * @author mmichaelbarboza
 * on 6:59 AM 3/7/2022
 * Time Taken:
 */
public class LC198HouseRobber {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,1};
        System.out.println(robDp(t));
    }

    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }

    public static int robDp(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int rob = 0;int noRob = 0;
        for(int i=0;i<nums.length;i++){
            int robi = noRob + nums[i];
            int noRobi = Math.max(rob,noRob);
            rob = robi;
            noRob = noRobi;
        }
        return Math.max(rob,noRob);
    }
}
