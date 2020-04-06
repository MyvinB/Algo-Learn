package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 @author Myvin Barboza
 06/04/20 12:17 PM
 link: https://www.youtube.com/watch?v=quAS1iydq7U&t=115s
 */
public class NextPermutationLC31 {
    ///6215430

    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    static void nextPermutation(int[] a) {
     int n=a.length;
     if(a==null || a.length<=1) return;
     int i=a.length-2;
     while(i>=0 && a[i]>=a[i+1]) i--;
     if(i>=0){
         int j=a.length-1;
         while(a[j]<=a[i])j--;
         swap(a,i,j);
     }
     System.out.println(Arrays.toString(a));
     reverse(a,i+1,a.length-1);

    }


    public static void main(String[] args) {
        //6215430
        //6230145
        //123

    int a[]={6,2,1,5,4,3,0};
    nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}