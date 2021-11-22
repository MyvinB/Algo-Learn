package practise;

public class LC34 {

    public int[] searchRange(int[] nums, int target) {
    int result[] = new int[2];
    result[0] = binarySearchFirstOne(nums,target);
    result[1] = binarySearchSecondOne(nums,target);
    return result;
    }

    public int binarySearchFirstOne(int[] nums,int target){
        int index= -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }
            else low=mid+1;
            if(nums[mid]==target)index=mid;
        }
        return index;
    }

    public int binarySearchSecondOne(int[] nums,int target){
        int index= -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]<=target){
                low = mid+1;
            }
            else high=mid-1;
            if(nums[mid]==target)index=mid;
        }
        return index;
    }



}
