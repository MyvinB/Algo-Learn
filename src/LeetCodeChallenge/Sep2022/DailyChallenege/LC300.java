package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC300 {

    public static void main(String[] args) {
        int[] t = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(t));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(nums,0,-1,dp);
    }

    public static int recurMemo(int[] nums,int idx,int prevIdx,int[][] dp){
        if(idx==nums.length) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
        int take = 0;
        int noTake = recurMemo(nums,idx+1,prevIdx,dp);
        if(  prevIdx==-1|| nums[idx]>nums[prevIdx]){
            take = 1 + recurMemo(nums,idx+1,idx,dp);
        }
        return dp[idx][prevIdx+1] =  Math.max(take,noTake);
    }

    public int tabulation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int prev_idx = i-1;prev_idx>=-1;prev_idx--){
                int noTake = dp[i+1][prev_idx+1];
                int take = 0;
                if( prev_idx==-1|| nums[i]>nums[prev_idx]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][prev_idx+1]  = Math.max(take,noTake);
            }
        }
        return dp[0][-1+1];
    }

    public int tabulationEasier(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] bk = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++) bk[i]=i;
        int max = 1;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    if((1+dp[prev])>dp[i]){
                        bk[i] = prev;
                    }
                    dp[i] = Math.max(dp[i],1+dp[prev]);
                    if(dp[i]>max){
                        lastIndex = i;
                    }
                    max = Math.max(max,dp[i]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(bk));
        if(lastIndex==-1) return max; //only one lement print nothing
        int lis[] = new int[max];
        int k = max-1;
        lis[k] = nums[lastIndex];
        //Printing the LIS
        while(bk[lastIndex]!=lastIndex){
            int newIndex  = bk[lastIndex];
            lis[--k] = nums[newIndex];
            lastIndex = newIndex;
        }
        //Print the lis
        System.out.println(Arrays.toString(lis));
        return max;
    }


    //Better time n logn
    public int tabulationFasterTime(int[] nums){
        int n = nums.length;
        int[] temp = new int[n];
        int size = 0;
        for(int x:nums){
            int i = 0, j = size;
            while(i!=j){
                int mid = i + (j-i)/2;
                if(temp[mid]<x){
                    i = mid+1;
                }else j = mid;
            }
            temp[i] = x;
            if(i==size)size++;
        }
        return size;
    }
}
