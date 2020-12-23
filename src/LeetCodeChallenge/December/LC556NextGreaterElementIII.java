package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 23/12/20 8:28 PM 
 */

import java.util.Arrays;

public class LC556NextGreaterElementIII {

    public static void main(String[] args) {

    }

    public int nextGreaterElement(int n) {
    char[] number = (""+n).toCharArray();
    int i,j;
    for(i = number.length-1; i>0;i--)
        if(number[i-1]<number[i])
            break;

    if (i==0){
        return -1;
    }
    int x = number[i-1];
    int smallest = i;

    for(j=i+1; j<number.length ;j++){
        if( number[j]>x && x < number[smallest]){
            smallest = j;
        }
    }

    char temp = number[i-1];
    number[i-1]= number[smallest];
    number[smallest] =temp;

    Arrays.sort(number, i, number.length);

    long val = Long.parseLong(new String(number));
    return (val<=Integer.MAX_VALUE)? (int)val: -1;
    }

}
