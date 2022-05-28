package LeetCodeChallenge.MAY2022;

public class LC268 {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
        }
        int n = nums.length;
        int total = n*(n+1)/2;
        return total -sum;
    }
}
