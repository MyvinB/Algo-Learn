package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC462 {
    public static void main(String[] args) {
        int t[] = new int[]{1,10,2,9};
    }
/*
* We need to find the median and need to add a value in the front of the median and delete end
* 1  2   3
* +1  0  -1
* 1+x= 3-y since they both need to be eequal
* x+y = 3-1=2; which is our answer
*
* */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i =0,j=nums.length-1,sum=0;
        while(i<j){
            sum+= nums[j]-nums[i];
        }
        return sum;
    }
}
