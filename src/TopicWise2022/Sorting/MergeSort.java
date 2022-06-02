package TopicWise2022.Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int a[]={10,16,8,12,15,6,3,9,5};
        int p[]={7,6,5,4,3,2,1};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int nums[], int p, int q, int r){
        int n1 = q-p+1;//including q
        int n2 = r-q;//not including q
        int[] left = new int[n1+1];
        int[] right = new int[n2+1];
        for(int i=0;i<n1;i++){
            left[i] = nums[p+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = nums[q+1+i];
        }
        ;

        int i=0,j=0;left[n1] = Integer.MAX_VALUE; right[n2] = Integer.MAX_VALUE;
        for(int k=p;k<=r;k++){
            if(left[i]<=right[j]){
                nums[k] = left[i++];
            }else nums[k] = right[j++];
        }
    }

    public static void mergeSort(int[] nums,int l, int h){
        if(l<h){
            int mid = l+ (h-l)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,h);
            merge(nums,l,mid,h);
        }
    }
}
