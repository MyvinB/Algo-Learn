package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {

    public static void main(String[] args) {
        int[] t = new int[]{4, 3, 2, 1};
        System.out.println(spaceOpti(t,5));

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return recurMemo(arr,n-1,k,dp);
    }

    public static boolean spaceOpti(int[] arr,int target){
        int n = arr.length;
        int[] prev = new int[target+1];
        int[] cur = new int[target+1];
        //base cases expressed in dp took care of zero
        //if target==0 then true
        //if idx == 0 and target == a[0]
        if(arr[0]<=target) prev[arr[0]] = 1;
        for(int idx=1;idx<n;idx++) {
            prev[0] = 1;
            for(int k=1;k<=target;k++){
                int take = 0;
                if(k>=arr[idx]) take = prev[k-arr[idx]];
                int noTake = prev[k];
                if(take ==1) cur[k] =1;
                if(noTake==1) cur[k] = 1;
            }
            prev = Arrays.copyOf(cur,target+1);
        }
        return cur[target]==1;
    }

    public static boolean tabulation(int[] arr,int target){
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        //base cases expressed in dp took care of zero
        //if target==0 then true
        for(int i=0;i<dp.length;i++) dp[i][0] = 1;
        //if idx == 0 and target == a[0]
        if(arr[0]<=target) dp[0][arr[0]] = 1;
        for(int idx=1;idx<n;idx++) {
            for(int k=1;k<=target;k++){
                int take = 0;
                if(k>=arr[idx]) take = dp[idx-1][k-arr[idx]];
                int noTake = dp[idx-1][k];
                if(take ==1) dp[idx][k] =1;
                if(noTake==1) dp[idx][k-arr[idx]] = 1;
            }
        }
        return dp[n-1][target]==1;
    }




    public static boolean recurMemo(int[] arr, int idx,int target,int[][] dp){
        //base case
        if(target==0) return true;
        if(idx==0) return arr[idx]==target?true:false;
        if(dp[idx][target]!=-1) return dp[idx][target]==1?true:false;

        //To make a choice
        boolean take = false,noTake=false;
        if(target>=arr[idx])
            take = recurMemo(arr,idx-1,target-arr[idx],dp);
        noTake = recurMemo(arr,idx-1,target,dp);
        dp[idx][target] = take || noTake ?1:0;
        return take||noTake;
    }


}
