package LeetCode.Array;

/*
 @author Myvin Barboza
 11/03/20 5:30 AM
 Link: https://www.youtube.com/watch?v=Zb4eRjuPHbM
 */

public class JumpGameLC55 {

    static boolean canJumpFromPosition(int position, int[] nums) {
        int lastPosIndex=nums.length-1;
            for (int i = nums.length-1; i >=0 ; i--) {
                if(nums[i]+i>=lastPosIndex){
                    lastPosIndex=i;
                }
            }
            return lastPosIndex==0;
    }


     static boolean canJump(int[] nums) {
      return canJumpFromPosition(0,nums);
    }

    public static void main(String[] args) {
    int nums[]={2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}