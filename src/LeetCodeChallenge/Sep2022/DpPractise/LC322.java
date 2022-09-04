package LeetCodeChallenge.Sep2022.DpPractise;

import java.util.Arrays;

public class LC322 {

    public static void main(String[] args) {

    }

    public int coinChangeT(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                int balance = i-coins[j];
                if(balance>=0){
                    dp[i] = Math.min(dp[i],1+dp[balance]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount]==amount+1?-1:dp[amount];
    }

    public int coinChangeTry(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                int balance = j-coins[i];
                if(balance>=0){
                    dp[j] = Math.min(dp[j],1+dp[balance]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount]==amount+1?-1:dp[amount];
    }

    public int coinChangeTabulation(int[] coins,int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }
        for(int i=1;i<n;i++){
            for(int t=1;t<=amount;t++){
                int notTake = dp[i-1][t];
                int take = Integer.MAX_VALUE;
                if(t-coins[i]>=0)
                    //Since we are taking the same index it might be exponential time here
                    take = 1+ dp[i][t-coins[i]];
                dp[i][t] =Math.min(take,notTake);
            }
        }
        int ans = dp[n-1][amount];
        return ans>=Math.pow(10,9)?-1:ans;
    }

    public int coinChangeSpaceOptimised(int[] coins,int amount){
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount;i++){
            if(i%coins[0]==0) dp[i] = i/coins[0];
            else dp[i] = (int)Math.pow(10,9);
        }
        for(int i=1;i<n;i++){
            for(int t=1;t<=amount;t++){
                int notTake = dp[t];
                int take = Integer.MAX_VALUE;
                if(t-coins[i]>=0)
                    //Since we are taking the same index it might be exponential time here
                    take = 1+ dp[t-coins[i]];
                dp[t] =Math.min(take,notTake);
            }
        }
        int ans = dp[amount];
        return ans>=Math.pow(10,9)?-1:ans;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int ans = recurMemo(coins,dp,n-1,amount);
        return ans>=Math.pow(10,9)?-1:ans;
    }

    public int recurMemo(int[] coins,int[][] dp, int index,int target){
        if(index==0){
            if(target%coins[0]==0) return target/coins[0];
            return (int) Math.pow(10,9);
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = recurMemo(coins,dp,index-1,target);
        int take = Integer.MAX_VALUE;
        if(target-coins[index]>=0)
            //Since we are taking the same index it might be exponential time here
            take = 1+ recurMemo(coins,dp,index,target-coins[index]);
        return dp[index][target] =Math.min(take,notTake);
    }
}

