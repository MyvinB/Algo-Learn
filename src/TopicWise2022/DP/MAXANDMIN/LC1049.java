package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 10:35 AM 4/12/2022
 * Time Taken:
 */
public class LC1049 {

    public static void main(String[] args) {
        int[] t = new int[]{2,7,4,1,8,1};
        lastStoneWeightII(t);
    }

    public static int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;

        for(int i=0;i<n;i++) sum+= stones[i];
        int[][] dp = new int[n+1][sum/2+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>=stones[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }else dp[i][j] = dp[i-1][j];
            }
        }

        return sum - 2*dp[n][sum/2];
    }
}
