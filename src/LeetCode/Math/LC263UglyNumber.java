package LeetCode.Math;/*
 @author Myvin Barboza
 04/07/20 2:44 PM 
 */

public class LC263UglyNumber {


    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
    static boolean isUgly(int n) {
       for(int i=2;i<6 && n>0;i++){
           while(n%i==0)n/=i;
       }
       return n==1;
    }
}
