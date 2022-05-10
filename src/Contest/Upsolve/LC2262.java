package Contest.Upsolve;

import java.util.Arrays;

public class LC2262 {
    //https://www.youtube.com/watch?v=D3JXFdGTizg

    public static void main(String[] args) {

    }

    public long appealSum(String s) {
        //https://www.youtube.com/watch?v=D3JXFdGTizg
        int n = s.length();
        long[] dp = new long[n+1];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex,-1);
        long ans = 0l;
        //Important to undetstand how the recurance relation is formed
        for(int i=0;i<n;i++){
            int c = s.charAt(i)-'a';
            dp[i+1] = dp[i]+i-lastIndex[c];
            ans+=dp[i+1];
            lastIndex[c] = i;
        }
        return ans;
    }
}
