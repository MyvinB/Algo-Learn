package LeetCode.BinarySearch;

/**
 * @author mmichaelbarboza
 * on 4:14 AM 12/16/2021
 */
public class LC704 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid]<target)low=mid+1;
            else if(nums[mid]>target) high=mid-1;
            else if(nums[mid]==target) return mid;
        }
        return -1;
    }
}
