package practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*Simple median
* 1234 median is (2+3)/2*/

public class Median {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numf=new int[nums1.length+nums2.length];
        int i=0;
        for(int a:nums1){
            numf[i]=a;
            i++;
        }
        for(int b:nums2){
            numf[i]=b;
            i++;
        }
        i=i-1;
        Arrays.sort(numf);
        if(i%2==0)return (float) numf[i/2];
        else return (float) (numf[i/2]+numf[i/2+1])/2;
    }

    public static void main(String[] args) {
        int[] a={1,3};
        int[] b={2};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
