package LeetCode.DP;
/*
 @author Myvin Barboza
 22/05/20 11:16 AM 
 */

import java.util.Arrays;

public class LC300LongestIncreasingSubsequence {

    static int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        int maxLength=0;
        for (int i = 0; i <nums.length ; i++) {
            int len=1;
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    len=Math.max(len,dp[j]+1);
                }
            }
            dp[i]=len;

            maxLength= Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }

    public int lengthOfLISDiff(int[] nums) {
        int n =nums.length;
        int dp[] =new int[n];
        Arrays.fill(dp,1);
        if(nums.length ==0) return 0;
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]> nums[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    max=Math.max(dp[i],max);
                }
            }
        }

        return max;
    }

    static int BinarylengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int len=0;
        for(int num:nums){
            int index= Arrays.binarySearch(dp,0,len,num);

            if(index<0){
                index=-(index+1);
            }

            dp[index]=num;
            if(index==len){
                 len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
     int num[]={10,9,2,5,3,7,101,18};
        System.out.println(BinarylengthOfLIS(num));
        System.out.println(lengthOfLIS(num));
    }
}