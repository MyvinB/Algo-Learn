package BitWiseAlgo;/*
 @author Myvin Barboza
 3/12/2020 6:09 PM
 */

import java.util.Arrays;

public class SingleNumberLC136 {

    //nlogn time
    static int singleNumber(int[] a) {
        Arrays.sort(a);

        for (int i = 0; i < a.length - 1; i = i + 2) {
            if (a[i] != a[i + 1]) return a[i];
        }
        return a[a.length - 1];
    }

   //n
    static  int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int a[] = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(a));
        System.out.println(singleNumber(a,a.length));

    }
}
