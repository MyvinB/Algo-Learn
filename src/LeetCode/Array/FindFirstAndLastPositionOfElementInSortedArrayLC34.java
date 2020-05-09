package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 24/04/20 9:51 AM 
 */public interface FindFirstAndLastPositionOfElementInSortedArrayLC34 {

    static int[] searchRange(int[] nums, int target) {
        int a[]=new int[2];
        a[0]=-1;
        a[1]=-1;
        if(nums.length==1 && nums[0]==target){
            a[0]=0;
            a[1]=0;
            return a;
        }
        int low=0;
        int high=nums.length-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target){
            int start=mid;
            while(start-1>=0 && nums[start]==nums[start-1])start--;
            a[0]=start;
            int end=mid;
            while(end+1<nums.length && nums[end]==nums[end+1])end++;
            a[1]=end;
            break;
        }
        else if(target>nums[mid]){
            low=mid+1;
        }
        else if(target<nums[mid]){
            high=mid-1;
        }
    }
    return a;
    }


     public static void main(String[] args) {
        int nums[]={2,2};
         System.out.println(Arrays.toString(searchRange(nums,2)));

    }
}
