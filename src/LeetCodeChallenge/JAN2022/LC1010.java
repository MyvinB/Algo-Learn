package LeetCodeChallenge.JAN2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 8:03 AM 1/2/2022
 */
public class LC1010 {
    public static void main(String[] args) {
        int[] a ={60,60,60};
        System.out.println(numPairsDivisibleBy60(a));

    }

    public static int numPairsDivisibleBy60(int[] time) {
        /*
        * (x+t)%60 ==0 or 60
        * basically consider x%60 having remainder 20 and t%60 haviong remainder 40 together they make 60 which makes it divisble
        * x%60 + t%60 = 60
        * x%60 = 60-t%60
        * Now take a case where t%60 is equal to zero we would get 60 as an answer for the other number to get it as zero we mod 60 again
        * x%60 = (60-t%60)%60
        * now the max time can be 500 so making it divisible will be 500+100 -> 600
        * no other divisible combo works 500+200 ,500+300,500+400..
        * x%60 = (600-t)%60 removes the need for mod operation multiple times...
        *
        * */
        int c[] = new int[60],res=0;
        for(int t:time){
            res += c[(600-t)%60];
            c[t%60]+=1;
        }
        return res;
    }
}
