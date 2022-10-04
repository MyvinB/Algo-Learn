package LeetCodeChallenge.Oct2022.DP.PartionDp;

public class LC1043 {

    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<dp.length;i++) dp[i] = -1;
        return recurMemo(arr,k,0,dp);
    }

    public int recurMemo(int[] arr,int k,int i,int[] dp){
        if(i==arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxEle = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            int len = j-i+1;
            maxEle = Math.max(maxEle,arr[j]);
            int sum = (maxEle * len) + recurMemo(arr,k,j+1,dp);
            res = Math.max(sum,res);
        }
        return dp[i]=res;
    }
}
