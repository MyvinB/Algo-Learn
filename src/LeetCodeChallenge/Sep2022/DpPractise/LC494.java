package LeetCodeChallenge.Sep2022.DpPractise;

public class LC494 {

    public static void main(String[] args) {

    }

    //Exactly same to CountPartionsWithGivenDifference Striver DP 18
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int d = target;
        for(int i=0;i<nums.length;i++) sum+= nums[i];
        int t = (sum-d)/2;
        if((sum-d)<0 || (sum-d)%2==1) return 0;
        int[] dp= new int[t+1];
        if(nums[0]==0) dp[0] = 2;
        else dp[0] = 1;
        if(nums[0]!=0 && nums[0]<=t) dp[nums[0]] = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=t;j>=0;j--){
                if(j-nums[i]>=0){
                    dp[j] += dp[j-nums[i]];
                }
            }
        }
        return dp[t];
    }
}
