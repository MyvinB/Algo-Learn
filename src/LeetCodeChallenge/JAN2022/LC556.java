package LeetCodeChallenge.JAN2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 3:25 PM 1/21/2022
 */
public class LC556 {

    public static void main(String[] args) {

    }


    public int nextGreaterElement(int n) {
        //https://www.youtube.com/watch?v=eAfJJyaAmes&t=1002
        char[] num = (""+n).toCharArray();
        int i,j;
        for(i=num.length-1;i>0;i--){
            if(num[i-1]<num[i]) break;
        }
        //All greater numbers
        if(i==0) return -1;
        //find the decreasing number
        int x = num[i-1];
        int smallest = i;
        //Find the next greatest number
        for(j=i+1;j<num.length;j++) {
            if(num[j]>x && x< num[smallest]) {
                smallest=j;
            }
        }
        //exchange
        char temp = num[i-1];
        num[i-1] = num[smallest];
        num[smallest] = temp;
        //sort the remaining
        Arrays.sort(num,i,num.length);
        long val = Long.parseLong(new String(num));
        return val<=Integer.MAX_VALUE? (int)val:-1;

        }



}
