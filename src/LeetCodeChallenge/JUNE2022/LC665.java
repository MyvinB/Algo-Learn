package LeetCodeChallenge.JUNE2022;

public class LC665 {

    public static void main(String[] args) {
        int[] t = new int[]{3,4,2,3};
        System.out.println(checkPossibility(t));
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean change = false;
        for(int i=0;i<n-1;i++){
            if(nums[i]<=nums[i+1]) continue;
            if(change) return false;
            else {
                if(i==0 || nums[i+1]>=nums[i-1]){
                    nums[i] = nums[i+1];
                }else
                    nums[i+1] = nums[i];
                change = true;
            }
        }
        return true;
    }
}
