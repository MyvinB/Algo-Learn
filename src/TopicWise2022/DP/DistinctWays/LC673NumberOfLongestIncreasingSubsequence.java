package TopicWise2022.DP.DistinctWays;

import javax.lang.model.type.IntersectionType;
import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 4:07 PM 4/16/2022
 * Time Taken:
 */
public class LC673NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {

    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        int max = 1;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(len[j]+1>len[i]){
                        len[j] = len[i]+1;
                        count[i] = count[j];
                    }
                    else if(len[j]+1 == len[i]){
                        count[i] += count[j];
                    }
                }
            }
        }
        for(int i=0;i<n;i++)max = Math.max(len[i],max);
        for(int i=0;i<n;i++){
            if(len[i]==max) ans+= count[i];
        }
        return ans;
    }
}
