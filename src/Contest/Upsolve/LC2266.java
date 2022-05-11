package Contest.Upsolve;

public class LC2266 {

    public static void main(String[] args) {
        System.out.println(countTexts("344644885"));
    }

    public static int countTexts(String s) {
        int n = s.length();
        long dp[] = new long[n+1];
        dp[0] = 1;
        long mod = 1000000007;
        for(int i=1;i<=n;i++){
            char ch = s.charAt(i-1);
            dp[i] = dp[i-1];
            //consider the case where i =5 so ch = will be at 4 if 6 if they are different we do not go back 3 times v
            if(i>=2 && s.charAt(i-2)==ch) dp[i] = (dp[i]+dp[i-2])%mod;
            else continue;
            if(i>=3 && s.charAt(i-3)==ch) dp[i] = (dp[i]+dp[i-3])%mod;
            else continue;
            if((ch=='7' || ch=='9') && i>=4 && s.charAt(i-4)==ch) dp[i] = (dp[i]+dp[i-4])%mod;
        }
        return (int)dp[n];
    }
}
