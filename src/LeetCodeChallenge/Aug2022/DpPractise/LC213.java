package LeetCodeChallenge.Aug2022.DpPractise;

public class LC213 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,1};
        System.out.println(rob(t));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int withOutFirst = state(nums,1,n-1);
        int withOutLast = state(nums,0,n-2);
        return Math.max(withOutFirst,withOutLast);
    }

    public static int state(int[] nums,int start,int end ){
        int n = nums.length;
        int cur=0,prev1=0,prev2=0;
        for(int i=start;i<=end;i++){
            int pick = nums[i] + prev2;
            int noPick = prev1;
            cur = Math.max(pick,noPick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

