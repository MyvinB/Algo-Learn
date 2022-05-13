package TopicWise2022.DP.DistinctWays;

public class LC1296NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    public static void main(String[] args) {

    }

    public int numWays(int steps, int arrLen) {
        int min = Math.min(steps,arrLen);
        long[][] dp = new long[steps+1][min+1];
        dp[0][0] = 1;
        int mod = 1000000007;
        for(int i=1;i<=steps;i++){
            for(int j=0;j<min;j++){
                //stay      //move right    //move left
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j>0?dp[i-1][j-1]:0)) %mod;
            }
        }
        return (int)dp[steps][0];
    }
    
}
