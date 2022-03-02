package practise;

import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
/*Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120
Number of trailing zeros = 1
So, return 1*/

class TrailingZero {


    static int cal(int n){
        int count = 0;

        // Keep dividing n by powers of 5 and update count
        for (int i=5; n/i>=1; i *= 5)
            count += n/i;

        return count;
    }
    public static void main(String[] args) {
        int n=60;
       // System.out.println(30/25);


//o(n) complexity
//        int count=0;
//        for (int i = 2; i <=n ; i++) {
//            int temp=i;
//            while(temp%5==0){
//                //System.out.println(temp);
//                count++;
//                temp=temp/5;
//            }
//        }
//        System.out.println(count);
        System.out.println(cal(n));

    }
}
