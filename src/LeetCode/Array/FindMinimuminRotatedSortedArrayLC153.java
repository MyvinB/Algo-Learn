package LeetCode.Array;

/*
 @author Myvin Barboza
 07/04/20 6:25 PM 
 */
public class FindMinimuminRotatedSortedArrayLC153 {

    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if( mid >0 && nums[mid]<nums[mid-1])   return nums[mid];
            else if(nums[start]<=nums[mid] && nums[mid]>=nums[end]){
                start=mid+1;
            }
            else {
                end=mid-1;
            }


        }
        return nums[start];
    }

    public static void main(String[] args) {
        // [4,5,6,7,0,1,2]

        // [7,0,1,2,4,5,6]
    }
}