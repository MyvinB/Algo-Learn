package LeetCodeChallenge.July2022;

public class LC629 {

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        System.out.println(kInversePairs(1000,1000));
    }
    public static int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0) dp[i][j] = 1;
                else{
                    for(int p=0;p<=Math.min(i-1,j);p++){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-p])%mod;
                    }
                }
            }
        }
        return dp[n][k];
    }
}
