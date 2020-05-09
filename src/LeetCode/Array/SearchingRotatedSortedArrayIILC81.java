package LeetCode.Array;

/*
 @author Myvin Barboza
 07/04/20 6:31 PM 
 */
//[4,5,6,7,0,1,2]
//[6,7,0,1,2,4,5]
public class SearchingRotatedSortedArrayIILC81 {

    static int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if( mid!=0 && nums[mid]<nums[mid-1]) return nums[mid];
            //else if(nums[mid]==nums[mid-1])mid--;
            else if(nums[start]<=nums[mid]  && nums[mid]>=nums[end])start=mid+1;
             else end=mid-1;
        }
        return nums[start];
    }


    public static void main(String[] args) {
    int a[]={1,3,3};
        System.out.println(findMin(a));
    }
}