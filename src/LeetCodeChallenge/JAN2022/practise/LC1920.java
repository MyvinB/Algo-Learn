package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:01 AM 1/11/2022
 */
public class LC1920 {

    public static void main(String[] args) {

    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] + n*(nums[nums[i]]%n);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]/n;
        }
        return nums;
    }
}
