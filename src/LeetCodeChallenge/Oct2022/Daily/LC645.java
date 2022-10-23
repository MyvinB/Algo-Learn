package LeetCodeChallenge.Oct2022.Daily;

import java.util.Arrays;

public class LC645 {

    public static void main(String[] args) {

    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+1];
        int[] res = new int[2];
        for(int i=0;i<n;i++){
            a[nums[i]]++;
            if(a[nums[i]]==2){
                res[0] = nums[i];
            }
        }
        for(int i=1;i<a.length;i++){
            if(a[i]==0){
                res[1] = i;
            }
        }
        return res;
    }
}