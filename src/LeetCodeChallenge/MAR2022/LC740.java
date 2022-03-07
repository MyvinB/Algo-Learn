package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 6:38 AM 3/7/2022
 * Time Taken:
 */
public class LC740 {

    public static void main(String[] args) {

    }

    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] ar = new int[n];
        for(int i=0;i<nums.length;i++){
            ar[nums[i]] += nums[i];
        }
        int take=0;int skip=0;
        for(int i= 0;i<n;i++){
            //Assuming we take i ie we have to skip
            int takei = skip + ar[i];
            //Skiping i we have to take max of prev skipped val or taken val;
            //Dp[i-1] would already have the computation if the taken val or skipped val is maximum we do not have it hence doing it
            int skipi = Math.max(skip,take);
            take = takei;
            skip = skipi;
        }
        return Math.max(skip,take);
    }

    public int deleteAndEarnDp(int[] nums) {
        int n = 10001;
        int[] ar = new int[n];
        for(int i=0;i<nums.length;i++){
            ar[nums[i]] += nums[i];
        }
        int[] dp = new int[n];
        dp[0] = ar[0];
        dp[1] = ar[1];
        for(int i =0;i<n;i++){
            dp[i] = Math.max(ar[i]+dp[i-2],dp[i-1]);
        }
        return dp[10000];
    }
}
