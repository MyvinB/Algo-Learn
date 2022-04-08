package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 8:01 AM 4/7/2022
 * Time Taken:
 */
public class LC746 {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for(int i=0;i<cost.length;i++){
            if(i<2) dp[i] =cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
