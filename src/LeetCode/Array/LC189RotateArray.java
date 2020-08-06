package LeetCode.Array;/*
 @author Myvin Barboza
 06/08/20 8:20 PM 
 */

public class LC189RotateArray {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }



    void reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }

}
