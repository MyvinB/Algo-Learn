package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 09/04/20 10:03 AM 
 */
public class PlusOneLC66 {
    //999 ->1000
    //199 ->200
    //109 ->110
    //9->10
    //8421 1001 -

        ///199
    //199
    static int[] plusOne(int[] digits) {
    int n=digits.length;
    digits[n-1]+=1;
    int carry=0;
    int temp[]=new int[n+1];
        for (int i = n-1; i >=0 ; i--) {
            digits[i]=digits[i]+carry;
            carry=0;
            if(digits[i]>9){
                carry=digits[i]/10;
                digits[i]=digits[i]%10;
            }
        }
        if(carry!=0){
            temp[0]=1;
            return temp;
        }
        return digits;
    }


    public static void main(String[] args) {
      int a[]={1,2,9};
        System.out.println(Arrays.toString(plusOne(a)));;
    }
}