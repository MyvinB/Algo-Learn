package TopicWise2022.Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[]={10,16,8,12,15,6,3,9,5};
        int p[]={7,6,5,4,3,2,1};


        quickSort(p,0,p.length-1);
        System.out.println(Arrays.toString(p));
    }

    private static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partion(int[] nums,int l,int h){
        int p = l;
        int i=l,j=h;
        while(i<j){
            while(nums[i]<nums[p]) i++;
            while(nums[j]>nums[p])j--;
            if(i<j) swap(nums,i,j);
        }
        swap(nums,p,j);
        return j;
    }

    public static void quickSort(int[] nums,int l,int h){
        if(l<h){
            int pivot = partion(nums,l,h);
            quickSort(nums,l,pivot-1);
            quickSort(nums,pivot+1,h);
        }
    }
}
