package practise;

/**
 * @author mmichaelbarboza
 * on 2:33 PM 11/25/2021
 */
public class LC53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int prev=nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int current_max = Math.max(prev+nums[i],nums[i]);
            prev=current_max;
            max= Integer.max(max,current_max);
        }
        return max;
    }
}
