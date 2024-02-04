package Year2024.Feb;

import java.util.Arrays;

public class LC1043 {

    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return recurMemo(arr,0,k,dp);
    }


    public int recurMemo(int[] arr, int idx, int k,int[] dp){
        int n = arr.length;
        if(idx == n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int sum= 0;
        int max = Integer.MIN_VALUE;
        int maxAr = Integer.MIN_VALUE;
        int len = 0;
        for(int i=idx;i<Math.min(idx+k,n);i++){
            maxAr = Math.max(maxAr,arr[i]);
            len++;
            sum = maxAr*len +recurMemo(arr,i+1,k,dp);
            max = Math.max(max,sum);
        }
        return dp[idx]=max;
    }
}
