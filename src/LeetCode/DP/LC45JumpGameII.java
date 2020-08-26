package LeetCode.DP;

public class LC45JumpGameII {
    public static void main(String[] args) {

    }
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length<2) return 0;
        int count=nums[0];
        int pos=nums[0];
        //first jump is taken
        int jump=1;
        for(int i=1;i<nums.length;i++){

            if(i>count){
                jump++;
                count=pos;
            }
            pos=Math.max(pos,i+nums[i]);
        }
        return jump;
    }
}
