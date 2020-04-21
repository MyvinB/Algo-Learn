package Array;

/*
 @author Myvin Barboza
 21/04/20 11:15 AM 
 */

import java.util.Arrays;

public class SortColorsLC75 {

    static void sortColors(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int index=0;
        while(start<=end && index<=end){
            if(nums[index]==0){
                nums[index]=nums[start];
                nums[start]=0;
                //no such problem when we encounter a zero cause if there was a two before it would have gone to the end already left is one that
                // needs to come to the middle
                start++;
                index++;
            }
            else if(nums[index]==2){
                nums[index]=nums[end];
                nums[end]=2;
                end--;
                //we dont increment the index here {1,2,0} {1,0,2} 0 needs to be checked again but that cant happen if we move
                //forward i
            }
            else //for the element 1
            index++;
        }
    }

    public static void main(String[] args) {

        int nums[]={1,2,0};
                //{2,0,2,1,1,0};

        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}