package Company.Amazon;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 11:18 AM 3/30/2022
 * Time Taken:
 */
public class LC300 {

    public static void main(String[] args) {
        int[] t = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISOptimised(t));
    }
    //Nlogn
    public static int lengthOfLISOptimised(int[] nums) {
        int[] tails = new int[nums.length];
        int size =0;
        for(int x:nums){
            int i=0,j=size;
            while(i!=j){
                int mid = i + (j-i)/2;
                if(tails[mid]<x){
                    i=mid+1;
                }else j=mid;
            }
            tails[i] = x;
            if(i==size)size++;
        }
        return size;
    }

    //n2
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       int n = nums.length;
       int max = 1;
       Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }


}
