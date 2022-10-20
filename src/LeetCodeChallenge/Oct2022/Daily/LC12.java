package LeetCodeChallenge.Oct2022.Daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC12 {

    public static void main(String[] args) {

    }

    public String intToRoman(int num) {
        int[] div = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = num;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<div.length;){
           int val = div[i];
           if(n>=div[i]){
               n = n - div[i];
               sb.append(roman[i]);
           }else{
               i++;
           }
        }
        return sb.toString();
    }
}
