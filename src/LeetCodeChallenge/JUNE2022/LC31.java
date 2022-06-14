package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC31 {

    public static void main(String[] args) {
        int[] t = new int[]{5,4,3,2,1};
        nextPermutation(t);
        System.out.println(Arrays.toString(t));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        //13542 index is at 1
        // 1) find decreasing order from the back
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        // 14532
        // After finding the index swap the next minimum from the back
        if(index!=-1){
            for(int i=n-1;i>=0;i--){
                if(nums[index]<nums[i]){
                    swap(nums,index,i);
                    break;
                }
            }
        }
        //Swap number to form increasing order from decreasing
        //14235
        int lo = index+1;
        int hi = n-1;
        while(lo<hi){
            swap(nums,lo++,hi--);
        }
    }

    public static void swap(int[] t, int i, int j){
        int temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
