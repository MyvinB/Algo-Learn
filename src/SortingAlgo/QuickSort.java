package SortingAlgo;/*
 @author Myvin Barboza
 06/08/20 4:58 PM 
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
    int a[]={10,16,8,12,15,6,3,9,5};

    quickSort(0,a.length-1,a);

        System.out.println(Arrays.toString(a));
    }

  static  void quickSort(int l,int h,int a[]){
        if(l<h){
            int j=partion(l,h,a);
            quickSort(l,j-1,a);
            quickSort(j+1,h,a);
        }


    }

    static int partion(int l,int h,int a[]){
        int pivot=a[l];
        int i=l+1,j=h;
        boolean flag=false;
        while(i<j){
           while(a[i]<=pivot)i++;
           while(a[j]>pivot)j--;
           if(i<j){
            swap(i,j,a);
           }
           flag=true;
        }
        if(flag)
        swap(l,j,a);
        return j;
    }

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
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    static void swap(int i,int j,int a[]){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }



}
