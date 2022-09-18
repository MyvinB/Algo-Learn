package LeetCodeChallenge.Sep2022.DpPractise.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368 {

    public static void main(String[] args) {

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n==0) return res;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i=0;i<n;i++) hash[i] = i;
        int max  = 0;
        int lastIndex = -1;
        for(int i =0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && (dp[j]+1)>dp[i]){
                    dp[i] = 1+ dp[j];
                    hash[i] = j;
                    if(dp[i]>max) {
                        lastIndex = i;
                        max = dp[i];
                    }
                }
            }
        }

        if(lastIndex==-1 ){
            res.add(nums[0]);
            return res;
        }
        res.add(nums[lastIndex]);
        while(lastIndex!=hash[lastIndex]){
            int newIndex = hash[lastIndex];
            res.add(nums[newIndex]);
            lastIndex = newIndex;
        }
        return res;
    }
}
