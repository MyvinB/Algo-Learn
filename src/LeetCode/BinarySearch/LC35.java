package LeetCode.BinarySearch;

/**
 * @author mmichaelbarboza
 * on 4:21 AM 12/16/2021
 */
public class LC35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
