package LeetCodeChallenge.Aug2022;

public class LC41 {


    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // negative values mean nothing to us
        for(int i=0;i<n;i++) if(nums[i]<0) nums[i] = 0;
        //Now we have the minus index
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(val>=1 && val<=n){
                if(nums[val-1]>0)
                    nums[val-1] = -1 * nums[val-1];
                else if(nums[val-1]==0) nums[val-1] = -1*(n+1);
            }
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>=0) return i;
        }
        return nums.length+1;
    }
}
