package LeetCodeChallenge.Oct2022.Array;

public class LC33 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int lo =0 ,hi = nums.length-1;
        while(lo<hi){
            int mid = lo+ (hi-lo)/2;
            if(nums[lo]<nums[mid]){
                if(target<nums[lo] || target>nums[mid]) lo = mid+1;
                else hi = mid;
            }else{
                if(target<nums[mid] || target>nums[hi]) hi = mid-1;
                else lo = mid;
            }
        }
        if(nums[lo]==target) return lo;
        return -1;
    }
}
