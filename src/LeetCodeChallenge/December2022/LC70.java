package LeetCodeChallenge.December2022;

public class LC70 {

    public static void main(String[] args) {
//        System.out.println(climbStairs(3));
        System.out.println(tabulation(10));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n];
        for(int i=0;i<n;i++)dp[i]=-1;
        return recurMemo(0,10,dp);
    }

    public static int recurMemo(int idx, int n,int[] dp){
        if(idx>n) return 0;
        if(idx==n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        ///take one step
        int oneStep = recurMemo(idx+1,n,dp);
        int twoStep = recurMemo(idx+2,n,dp);
        return dp[idx] =oneStep+twoStep;
    }

    public static int tabulation(int n){
        if(n==1) return 1;
        int[] dp = new int[n];
        //base  conditions
        //to take one step there is one way
        //two take two steps there are two way ie 2 and 1 1
        dp[n-1] = 1;
        dp[n-2] =2;

        for(int i=n-3;i>=0;i--){
            dp[i] = dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
}
