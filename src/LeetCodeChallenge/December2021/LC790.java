package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 11:44 AM 12/11/2021
 */
public class LC790 {


    public int numTilings(int n) {
        if(n<3){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=n;i++){
            dp[i] = ((2*dp[i-1])%1000000007 + dp[i-3]%1000000007)%1000000007;
        }
        return dp[n];


    }
}
