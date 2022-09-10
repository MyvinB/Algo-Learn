package LeetCodeChallenge.Sep2022.GP;

public class LC300LongestIncreasingSubSequence {


    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int size = 0;
        int[] tails = new int[n];
        for(int x:nums){
            int i=0,j=size;
            while(i!=j){
                int m = i + (j-i)/2;
                if(tails[m]<x){
                    i = m+1;
                }else j = m;
            }
            tails[i] = x;
            if(i==size)size++;
        }
        return size;
    }
}
