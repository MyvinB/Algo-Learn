package LeetCodeChallenge.Aug2022.DpPractise;

public class LC198 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,1};
        System.out.println(rob(t));
    }

    public static int rob(int[] nums) {
        return tablulation(nums);
    }

    public static int recur(int[] nums,int idx){
        if(idx==0) return nums[0];
        if(idx<0) return 0;
        int pick = nums[idx] + recur(nums,idx-2);
        int noPick = recur(nums,idx-1);
        return Math.max(pick,noPick);
    }

    public static int recurMemo(int[] nums,int idx,int[] dp){
        if(idx==0) return nums[0];
        if(idx<0) return 0;
        if(dp[idx]!=0) return dp[idx];
        int pick = nums[idx] + recur(nums,idx-2);
        int noPick = recur(nums,idx-1);
        dp[idx] =  Math.max(pick,noPick);
        return dp[idx];
    }

    public static int tablulation(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int pick = nums[i];
            int noPick = 0;
            if(i>1) pick+=dp[i-2];
            if(i>0) noPick = dp[i-1];
            dp[i] = Math.max(pick,noPick);
        }
        return dp[n-1];
    }

    public static int state(int[] nums){
        int n = nums.length;
        int cur=0,prev1=0,prev2=0;
        for(int i=0;i<n;i++){
            int pick = nums[i] + prev2;
            int noPick = prev1;
            cur = Math.max(pick,noPick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
