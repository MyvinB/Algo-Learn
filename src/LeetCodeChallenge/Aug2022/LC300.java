package LeetCodeChallenge.Aug2022;

public class LC300 {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int i= 0,size=0,j = size;
        for(int x:nums){
            i = 0;
            j= size;
            while(i!=j){
                int mid = i +(j-i)/2;
                if(tails[mid]<x) i = mid+1;
                else j = mid;
            }
            tails[i] = x;
            if(i==size) size++;
        }
        return size;

    }
}
