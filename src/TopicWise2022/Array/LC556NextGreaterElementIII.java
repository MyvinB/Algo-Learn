package TopicWise2022.Array;

import java.util.Arrays;

public class LC556NextGreaterElementIII {

    public static void main(String[] args) {

    }

    public int nextGreaterElement(int n) {
        char nums[] = String.valueOf(n).toCharArray();
        int n1 = nums.length;
        int i,j;
        for(i =n1-2;i>=0;i--){
            if(nums[i]<nums[i+1]) break;
        }
        if(i==-1) return -1;
        //Since the back is in descending order already we iterate from the back to find the next min
        for(j=n1-1;j>=0;j--){
            if(nums[i]<nums[j]){
                swap(nums,i,j);
                break;
            }
        }
        int low = i+1;
        int high = n1-1;
        while(low<high){
            swap(nums,low,high);
            low++;high--;
        }

        long val = Long.parseLong(String.valueOf(nums));
        return val>Integer.MAX_VALUE?-1: (int) val;
    }

    public void swap(char nums[],int i,int j){
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
