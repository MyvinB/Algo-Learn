package Contest.LeetCode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:11 AM 3/13/2022
 * Time Taken:
 */
public class MaximizeTheTopmostElementAfterKMoves {

    public static void main(String[] args) {
        int[] t = new int[]{2};
        System.out.println(maximumTop(t,1));
    }

    public static int maximumTop(int[] nums, int k) {
        if(nums.length==1 && k%2==1) return -1;
        int max = 0;
        for(int i=0;i<Math.min(k-1,nums.length);i++){
            max = Math.max(max,nums[i]);
        }

        if (k<nums.length){
            max = Math.max(max,nums[k]);
        }
        return max;
    }
}
