package TopicWise2022.Array;

public class LC33SearchInARotatedSortedArray {

    public int search(int[] nums, int target) {
        int l =0;
        int h = nums.length-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[h]){
                if(target<nums[l] || target>nums[mid]){
                    l = mid+1;
                }else h=mid;
            }
            else {
                if(target<nums[mid] || target>nums[h]){
                    h=mid-1;
                }else l = mid;
            }
        }
        return -1;

    }
}
