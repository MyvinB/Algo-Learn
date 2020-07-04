package LeetCode.Math;/*
 @author Myvin Barboza
 04/07/20 6:15 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC264UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    static int nthUglyNumber(int n) {

        int uglyNumber[]=new int[n];
        uglyNumber[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        int i=1;
        while(i<n){
            int by2=uglyNumber[index2]*2;
            int by3=uglyNumber[index3]*3;
            int by5=uglyNumber[index5]*5;
            int min=Math.min(by2,Math.min(by3,by5));
            uglyNumber[i]=min;
            if(min==by2)index2++;
            if(min==by3)index3++;
            if(min==by5)index5++;
            i++;
        }

        return uglyNumber[i-1];
    }


}
