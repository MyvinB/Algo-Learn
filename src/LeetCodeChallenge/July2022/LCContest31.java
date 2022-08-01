package LeetCodeChallenge.July2022;

public class LCContest31 {

    public static void main(String[] args) {
        int[] t = new int[]{1,5,0,3,5};
        System.out.println(minimumOperations(t));
    }

    public static int minimumOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        while(true){
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0) min = Math.min(min,nums[i]);
            }
            if(min==Integer.MAX_VALUE) return count;
            int zeroCount = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0) {
                    nums[i] = nums[i]-min;
                }
                if(nums[i]==0) zeroCount++;
            }
            count++;
            if(zeroCount==nums.length)break;
            min = Integer.MAX_VALUE;
        }
        return count;
    }


    public int maximumGroups(int[] grades) {
        return -1;
    }
}
