package SortingAlgo;

import java.util.Arrays;

public class AllSort {
    public static void main(String[] args) {
        int[] a ={10,16,8,12,15,6,3,9,5};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void bubbleSort(int[] ar){
        int n = ar.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(ar[j]>ar[j+1]){
                  swap(j,j+1,ar);
                }
            }
            System.out.println(Arrays.toString(ar) +" index"+i);
        }
    }

    static void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
