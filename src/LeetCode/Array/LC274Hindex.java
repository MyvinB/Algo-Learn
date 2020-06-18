package LeetCode.Array;/*
 @author Myvin Barboza
 18/06/20 3:50 PM 
 */

import java.util.Arrays;

public class LC274Hindex {

    static int hIndex(int[] citations) {
        int n=citations.length;
        int a[]=new int[n+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=n)a[n]++;
            else a[citations[i]]++;
        }

        System.out.println(Arrays.toString(a));
        int total=0;
        for (int i = n; i >=0 ; i--) {
            total+=a[i];
            if(total>=i)return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = {3,0,6,5,1};
        System.out.println(hIndex(a));
    }

}
