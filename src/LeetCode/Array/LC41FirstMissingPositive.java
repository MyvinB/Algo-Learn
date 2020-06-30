package LeetCode.Array;/*
 @author Myvin Barboza
 30/06/20 12:57 PM
 help:https://www.youtube.com/watch?v=9SnkdYXNIzM
 */

import java.util.HashSet;

public class LC41FirstMissingPositive {

    public static void main(String[] args) {
        int a[]={7,8,9,10,11,12};
        System.out.println(firstMissingPositive(a));
    }


    static int firstMissingPositive(int[] nums) {
        if(nums.length==0 ) return 1;
        int n=nums.length;
        int check=0;
        //step1
        //also check if 1 exist if not return 1
        //changing the number to 1 for greater and negative
        for(int i=0;i<n;i++){
            if(nums[i]==1)check=1;
            if(nums[i]>n || nums[i]<=0) nums[i]=1;

        }

        if(check==0) return 1;
        //Step 2
        //converting the index to negative for already visited positive numbers
        //basically using the index to see what elements are visited
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            //change the index if not visited before
            if(nums[index]>0)nums[index]=-nums[index];
        }
        //seeing the first non visted element and returning it
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return i+1;
        }
        //if nothing found return arraysize+1
        return n+1;



    }


    //not done as said used set data strcuture
    public int firstMissingPositiveWRONGWAY(int[] nums) {
        if(nums.length==0 ) return 1;
        HashSet<Integer> set=new HashSet<>();
        for(int a:nums)set.add(a);

        for(int i=1;i<=nums.length;i++)if(!set.contains(i)) return i;

        return nums.length+1;
    }

}
