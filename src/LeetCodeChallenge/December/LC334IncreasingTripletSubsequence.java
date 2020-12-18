package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 18/12/20 8:54 PM 
 */

public class LC334IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
