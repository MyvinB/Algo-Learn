package TopicWise2022.Array;

import java.util.Arrays;

public class LC556NextGreaterElementIII {

    public static void main(String[] args) {

    }

    public int nextGreaterElement(int n) {
        char nums[] = String.valueOf(n).toCharArray();
        int n1 = nums.length;
        int i,j;
        for(i =n1-1;i>0;i--){
            if(nums[i-1]<nums[i]) break;
        }
        if(i==0) return -1;
        int x = nums[i-1];
        int smallest = i;
        for(j=i+1;j<n1;j++){
            if(nums[j]>x && nums[j]<nums[i]){
                smallest = j;
            }
        }
        char t = nums[smallest];
        nums[smallest] = nums[i-1];
        nums[i-1] = t;
        Arrays.sort(nums,i,n1);
        long val = Long.parseLong(String.valueOf(nums));
        return val>=Integer.MAX_VALUE?-1: (int) val;
    }
}
