package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;

public class LC88 {

    public static void main(String[] args) {
        int[] t = new int[]{0};
        int[] p = new int[]{1};
        merge(t,0,p,1);
        System.out.println(Arrays.toString(t));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        //nums1[i]==0
        while(j>=0){
                if( i>=0 && nums1[i]>nums2[j] ){
                    nums1[k--] = nums1[i--];
                }
                else {
                    nums1[k--] = nums2[j--];
                }
        }
    }


}
