package Year2023.JuneHalf;

import java.util.Arrays;

public class LC2090 {

    public static void main(String[] args) {
        int[] t = new int[]{7,4,3,9,1,8,5,2,6};
        getAverages(t,3);
    }

    //Using presum Technique
    public static int[] getAverages(int[] nums, int k) {
        long[] preSum = new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            preSum[i+1] +=preSum[i]+nums[i];
        }
        int d = (k*2)+1;
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=k;i<nums.length-k;i++){
            res[i] = (int)((preSum[i+k+1]-preSum[i-k])/d);
        }
        return res;
    }
}
