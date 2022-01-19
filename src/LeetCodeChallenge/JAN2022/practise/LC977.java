package LeetCodeChallenge.JAN2022.practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 12:59 PM 1/19/2022
 */
public class LC977 {

    public static void main(String[] args) {
        int nums[] = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        int result[] = new int[n];
        for(int i=n-1;i>=0;i--){
            if(Math.abs(nums[low])>Math.abs(nums[high])){
             result[i] = nums[low] * nums[low];
             low++;
            }
            else{
                result[i]= nums[high]*nums[high];
                high--;
            }
        }
        return result;
    }
}
