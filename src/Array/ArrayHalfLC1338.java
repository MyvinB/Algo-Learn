package Array;/*
 @author Myvin Barboza
 3/11/2020 6:39 PM
 */

import java.util.Arrays;
import java.util.HashMap;

public class ArrayHalfLC1338 {

    static int minSetSize(int[] arr) {
        int bucket[] = new int[100001];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        Arrays.sort(bucket);
        int count=0;
        int sum=0;
        int n=arr.length;
        for (int i = bucket.length-1; i >=0 ; i--) {
            sum=sum+bucket[i];
            count++;
            if(sum>=n/2)break;
        }
        return count;

    }


    public static void main(String[] args) {
        int a[]={1000,1000,3,7};
        System.out.println(minSetSize(a));
    }
}
