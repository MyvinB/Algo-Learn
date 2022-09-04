package LeetCodeChallenge.Sep2022.DpPractise;

public class DP18CountPartitionsWithGivenDifference {

    public static void main(String[] args) {

    }
    static int mod =(int)(Math.pow(10,9)+7);
    public static int countPartitions(int n, int d, int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+= nums[i];
        int target = (sum-d)/2;
        if(sum-d <0 || (sum-d)%2 ==1) return 0;
        // Write your code here.
        int[] dp = new int[target+1];
        //if target == 0;
        if(nums[0]==0) dp[0] = 2;
        else dp[0] = 1;
        //if idx==0 and target==a[0]
        if(nums[0]!=0 && nums[0]<=target) dp[nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                if(j>=nums[i])
                    dp[j] += dp[j-nums[i]];
                dp[j] = dp[j]%mod;
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[target];

    }
}
