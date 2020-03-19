package String;/*
 @author Myvin Barboza
 3/19/2020 3:43 PM
 */

import java.util.Arrays;

public class MultiplyStringsLC43 {

    static String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0')return "0";
        int store[]=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for (int j = n-1; j >=0 ; j--) {
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=mul+store[i+j+1];
                store[i+j+1]=sum%10;
                store[i+j]=store[i+j]+sum/10;
            }
        }
        StringBuilder s=new StringBuilder();
        System.out.println(Arrays.toString(store));
        int i=0;
        while(store[i]==0)i++;
        while(i<store.length)s.append(store[i++]);
        return s.toString();

    }

    public static void main(String[] args) {
        System.out.println( multiply("0","0"));
    }
}
