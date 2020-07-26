package LeetCode.Math;/*
 @author Myvin Barboza
 26/07/20 11:06 AM
 help:
 to know:https://leetcode.com/problems/solve-the-equation/discuss/105364/Python-Straightforward-with-Explanation
 */

import java.util.Arrays;

public class LC640SolvetheEquation {

    public static void main(String[] args) {

    }

    public String solveEquation(String s) {
        String part[]=s.split("=");
        int left[]=calculate(part[0]);
        int right[]=calculate(part[1]);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        if(left[0]==right[0] && left[1]==right[1])
            return "Infinite solutions";
        else if(left[0]==right[0])
            return "No solution";
        else return "x="+(right[1]-left[1])/(left[0]-right[0]);
    }



    public int[] calculate(String parts){
        String tokens[]=parts.split("(?=[+-])");

        int res[]=new int[2];
        for(String token:tokens){
            if(token.equals("x") || token.equals("+x")) res[0]++;
            else if(token.equals("-x")) res[0]--;
            else if(token.contains("x"))
                res[0]+=Integer.parseInt(token.substring(0,token.length()-1));
            else
                res[1]+=Integer.parseInt(token);
        }
        return res;
    }

}
