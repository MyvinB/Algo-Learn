package LeetCode.DP;

/*
 @author Myvin Barboza
 20/04/20 11:39 AM 
 */
public class HouseRobberLC198 {

    ///considering only robbeer 1 LC198
    static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length ; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    static int robCircle(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int a=rob0(nums);
        int b=rob1(nums);
        return Math.max(a,b);
    }

    static int rob0(int[] nums){
        int dp[]=new int[nums.length-1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length-1 ; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    static int rob1(int[] nums){
        int dp[]=new int[nums.length-1];
        dp[0]=nums[1];
        dp[1]=Math.max(nums[1],nums[2]);
        for (int i = 2; i+1 <nums.length ; i++) {
            dp[i]= Math.max(nums[i+1]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        int nums[]={1,2,1,1};
        System.out.println(robCircle(nums));
    }
}