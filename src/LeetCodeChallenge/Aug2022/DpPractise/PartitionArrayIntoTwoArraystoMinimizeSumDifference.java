package LeetCodeChallenge.Aug2022.DpPractise;

public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {

    public static void main(String[] args) {

    }

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        int target = sum;
        int[] dp = new int[target+1];
        //if target == 0;
        dp[0] = 1;
        //if idx==0 and target==a[0]
        // if(nums[0]<=target) dp[nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                if(j>=nums[i])
                    dp[j] = dp[j]==1 || dp[j-nums[i]]==1?1:0;
            }
            // System.out.println(Arrays.toString(dp));
        }
//  System.out.println(Arrays.toString(dp));
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[i]==1){
                min = Math.min(min,Math.abs((sum-i)-i));
            }
        }
        return min;
    }
}
