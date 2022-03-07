package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 8:26 AM 3/7/2022
 * Time Taken:
 */
public class LC1359 {
    public static void main(String[] args) {

    }

    public int countOrders(int n) {
      long res = 1, mod = (long)1e9 + 7;
      for(int i = 1;i<=n;i++){
          res *= i;
          res %= mod;
          res *= (2*i-1);
          res %= mod;
      }
      return (int)res;

    }

    public int countOrdersDp(int n) {
        if(n==1) return 1;
        long res = 1, mod = (long)1e9 + 7;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 6;

        for(int i = 3;i<=n;i++){
            int oddNo = 2 *i-1;
            int permutations = (oddNo * (oddNo+1))/2;
            dp[i] = (permutations * dp[i-1])%mod;
        }
        return (int)res;

    }

}
