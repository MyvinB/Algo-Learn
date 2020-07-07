package LeetCode.Math;/*
 @author Myvin Barboza
 04/07/20 7:04 PM 
 */

import java.util.Arrays;

public class LC1201UglyNumberIII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(5,2,11,13));
    }


   static int nthUglyNumber(int n, int a, int b, int c) {

        int uglyNumber[]=new int[n+1];
        uglyNumber[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        int i=1;
        while(i<=n){
            int by2=uglyNumber[index2]*a;
            int by3=uglyNumber[index3]*b;
            int by5=uglyNumber[index5]*c;
            int min=Math.min(by2,Math.min(by3,by5));
            uglyNumber[i]=min;
            if(min==by2)index2++;
            if(min==by3)index3++;
            if(min==by5)index5++;
            i++;
        }
       System.out.println(Arrays.toString(uglyNumber));
        return uglyNumber[i-1];
    }

}
