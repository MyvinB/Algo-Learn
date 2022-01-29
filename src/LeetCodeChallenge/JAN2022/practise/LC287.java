package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:33 PM 1/29/2022
 */
public class LC287 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
       int slow = nums[0];
       int fast = nums[0];
       do{
           slow = nums[slow];
           fast = nums[nums[fast]];
       }while(slow!=fast);

       slow = nums[0];

       while(slow!=fast){
           slow=nums[slow];
           fast=nums[fast];
       }
       return slow;
    }
}
