package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 15/04/20 9:52 AM 
 */
public class RemoveDuplicatesfromSortedArrayIILC80 {

    static int removeDuplicates(int[] nums) {
   int i=0;
   for(int n:nums){
       if(i<2 ||n>nums[i-2]){
           nums[i++]=n;
       }
   }
   return i;
    }

    public static void main(String[] args) {
    int nums[]={0,0,1,1,1,1,2,3,3};

    removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}