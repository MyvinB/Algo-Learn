package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 6:11 AM 3/28/2022
 * Time Taken:
 */
public class LC33 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            //see if left half is sorted
            if(nums[mid]==target) return mid;
            if(nums[low]<nums[mid]){
                if(target<nums[low] || target>nums[mid]){
                    low = mid+1;
                }else high =mid-1;
            }
            else if(nums[low]>nums[mid]) {
                if(target<nums[mid] || target>nums[high]){
                    high = mid-1;
                }else low = mid+1;
            }
            else low++;
        }
        return -1;
    }
}
