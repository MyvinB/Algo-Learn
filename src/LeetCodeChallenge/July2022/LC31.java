package LeetCodeChallenge.July2022;

import java.util.Arrays;

public class LC31 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3,5,4,2};
        nextPermutation(t);
        System.out.println(Arrays.toString(t));
    }


    public static void nextPermutation(int[] nums) {
        //13542
        //1 Find the decreasing order index first
        int n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        //14532
        //2 Find the next number greater than the number at the index from the back
        if(index!=-1){
            for(int i=n-1;i>=0;i--){
                if(nums[index]<nums[i]){
                    swap(nums,index,i);
                    break;
                }
            }
        }
        //14235
        //3 Since we have all the numbers from the index in decreasing order so use a two pointer swap to get them in ascending order
        int i = index+1;
        int j = n-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
