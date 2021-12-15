package LeetCode.DP;

/**
 * @author mmichaelbarboza
 * on 4:36 AM 12/16/2021
 */
public class LC509 {

    public static void main(String[] args) {

    }

    public int fib(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
