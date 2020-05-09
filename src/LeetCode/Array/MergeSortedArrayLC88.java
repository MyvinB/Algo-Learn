package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 11/04/20 11:08 AM 
 */
public class MergeSortedArrayLC88 {
//{1,2,2,3,0,0}
    //2,5,6
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length==0 ||nums2.length==0) return ;

        int j=0;
        for (int i = 0; i <nums1.length ; i++) {
            if(j <n && nums2[j]<nums1[i]){
                int k=m-1;
                while(k>=i){
                    nums1[k+1]=nums1[k];
                    k--;
                }
                nums1[i]=nums2[j];
                m=m+1;
                j++;
            }
            else if(i>=m &&j<n&& nums1[i]==0){
                nums1[i]=nums2[j];
                j++;
            }
        }
    }



    public static void main(String[] args) {
        int nums1[]={1,2,3,0,0,0};
        int nums2[]={2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}