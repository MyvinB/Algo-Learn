package LeetCodeChallenge.Aug2022.DpPractise;

public class LC416PartionEqualSubsetSum {

    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int target = sum/2;
        int[] dp = new int[target+1];
        int n = nums.length;
        //if target == 0;
        dp[0] = 1;
        //if idx==0 and target==a[0]
        if(nums[0]<=target) dp[nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                if(j>=nums[i])
                    dp[j] = dp[j]==1 || dp[j-nums[i]]==1?1:0;
            }
        }

        return dp[target]==1;

    }

}
