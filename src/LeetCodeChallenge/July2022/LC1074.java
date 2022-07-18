package LeetCodeChallenge.July2022;

import java.util.Arrays;
import java.util.HashMap;

public class LC1074 {

    public static void main(String[] args) {

    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] sub = new int[n];
        int count = 0;
        for(int i=0;i<m;i++){
            Arrays.fill(sub,0);
            for(int j=i;j<m;j++){
                for(int k=0;k<n;k++){
                    sub[k] += matrix[j][k];
                }
                count+= subarraySum(sub,target);
            }
        }
        return count;
    }


    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0,1);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
