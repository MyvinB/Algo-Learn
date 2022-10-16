package LeetCodeChallenge.Oct2022.Greedy;

public class LC55 {

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int reach = 0;
        for(int i=0;i<nums.length;i++){
            if(i>reach) return false;
            reach = Math.max(reach,nums[i]+i);
        }
        return true;
    }
}
