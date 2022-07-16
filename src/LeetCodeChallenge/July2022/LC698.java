package LeetCodeChallenge.July2022;

import java.util.Arrays;

public class LC698 {

    public static void main(String[] args) {

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int p:nums)sum+=p;
        if(sum%k!=0) return false;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        return dfs(nums,visited,nums.length-1,0,sum/k,k);
    }

    public boolean dfs(int[] nums,boolean[] visited,int indx,int sum,int target,int round){
        if(round==0) return true;
        if(sum==target && dfs(nums,visited,nums.length-1,0,target,round-1)) return true;
        for(int i=indx;i>=0;i--){
            if(!visited[i] && sum+nums[i]<=target){
                visited[i] = true;
                if(dfs(nums,visited,indx-1,sum+nums[i],target,round)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
