package LeetCodeChallenge.Aug2022.DpPractise;

import java.nio.charset.IllegalCharsetNameException;

public class FrogJumpWithKSteps {

    public static void main(String[] args) {
        int[] t = new int[]{40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int n = t.length;
        System.out.println(solveUtil(n,t,new int[n+1],4));
    }


    static int solveUtil(int n, int[] height, int[] dp, int k){
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    minSteps = Math.min(minSteps,Math.abs(height[i]-height[i-j])+dp[i-j]);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }
    }
