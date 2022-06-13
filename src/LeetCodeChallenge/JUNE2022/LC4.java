package LeetCodeChallenge.JUNE2022;

import java.nio.charset.IllegalCharsetNameException;

public class LC4 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3};
        int[] p = new int[]{2};
        System.out.println(findMedianSortedArrays(t,p));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if(x>y){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = x;
        while(low<=high){
            //first partion
            int partionX = (low+high)/2;
            //total elements minus partion x
            int partionY = (x+y+1)/2 - partionX;

            int maxXLeft = partionX==0?Integer.MIN_VALUE:nums1[partionX-1];
            int minXRight =partionX==x? Integer.MAX_VALUE:nums1[partionX];

            int maxYLeft = partionY==0?Integer.MIN_VALUE:nums2[partionY-1];
            int minYRight = partionY==y?Integer.MAX_VALUE:nums2[partionY];

            if(maxXLeft<=minYRight && maxYLeft<=minXRight){
                if((x+y)%2==0) return (double)(Math.max(maxXLeft,maxYLeft) +Math.min(minXRight,minYRight))/2;
                else return (double)Math.max(maxXLeft,maxYLeft);
            }else if(maxXLeft>minYRight){
                high = partionX;
            }else low =partionX+1;
        }
        return 0;
    }
}
