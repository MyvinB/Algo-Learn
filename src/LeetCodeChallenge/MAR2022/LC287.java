package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 10:44 AM 3/29/2022
 * Time Taken:
 */
public class LC287 {

    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
      int slow = nums[0];
      int fast = nums[0];
      do{
          slow = nums[slow];
          fast = nums[nums[fast]];
      }while(slow!=fast);

      slow = nums[0];
      while(slow!=fast){
          slow = nums[slow];
          fast = nums[fast];
      }

      return slow;

    }
}
