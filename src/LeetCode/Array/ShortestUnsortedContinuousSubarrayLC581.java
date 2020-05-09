package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 28/03/20 7:28 AM 
 */public class ShortestUnsortedContinuousSubarrayLC581 {

    static int findUnsortedSubarray(int[] a) {
       int temp[]=a.clone();
        Arrays.sort(temp);
        int start=0, end=a.length-1;
        while(start<a.length && a[start]==temp[start])start++;
        while(end> start&& a[end]==temp[end])end--;
        return end-start+1;
    }

     public static void main(String[] args) {
    int a[]={1,3,2,4,5};
         System.out.println(findUnsortedSubarray(a));
    }
}