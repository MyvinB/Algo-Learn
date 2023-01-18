package Year2023.Jan;

public class LC918 {

    public static void main(String[] args) {
        int[] t = new int[]{5,-3,-2,6,-1,4};
        System.out.println(maxSubarraySumCircular(t));
    }

    public static int maxSubarraySumCircular(int[] nums) {
       // https://www.youtube.com/watch?v=Q1TYVUEr-wY
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int maxRunningSum = 0;
        int minSum = Integer.MAX_VALUE;
        int minRunningSum = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            maxRunningSum += nums[i];
            maxSum = Math.max(maxSum,maxRunningSum);
            minRunningSum += nums[i];
            minSum = Math.min(minRunningSum,minSum);
            if(maxRunningSum<0) maxRunningSum = 0;
            if(minRunningSum>0) minRunningSum = 0;
            total+=nums[i];
        }
        if(total==minSum) return  maxSum;
        //total-minSum is a wrap around property
        return Math.max(total-minSum,maxSum);
    }
}
