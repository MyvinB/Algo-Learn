package Company.Amazon;

/**
 * @author mmichaelbarboza
 * on 9:20 AM 3/16/2022
 * Time Taken:
 */
public class LC33 {

    public static void main(String[] args) {
        int t[] = new int[]{5,1,3};
        System.out.println(search(t,5));
    }
        /// Best way to do it
    public static int search(int[] nums, int target) {
     int low = 0;
     int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(nums[mid]==target) return mid;
            //left half is sorted
            if(nums[low]<nums[mid]){
                if(target>=nums[low] && target<=nums[mid] ){
                    high = mid -1;
                } else low = mid+1;
            }
            //if left is not sorted that mean right is sorted
            else {
                if(target>=nums[mid] && target<=nums[high] ){
                    low = mid+1;
                } else high = mid-1;
            }
        }
        return -1;
    }
}
