package SortingAlgo;/*
 @author Myvin Barboza
 06/08/20 4:58 PM 
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
    int a[]={10,16,8,12,15,6,3,9,5};
    int p[]={7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(p));
    quickSort(0,a.length-1,a);

        System.out.println(Arrays.toString(a));
    }

  static  void quickSort(int l,int h,int a[]){
        if(l<h){
            int j=partition(l,h,a);
            quickSort(l,j-1,a);
            quickSort(j+1,h,a);
        }


    }
    //2,1



    static int partition( int low, int high,int arr[])
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                swap(i,j,arr);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
       swap(i+1,high,arr);

        return i+1;
    }

    static void swap(int i,int j,int a[]){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }



}
