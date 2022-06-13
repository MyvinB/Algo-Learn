package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;
import java.util.Map;

public class LC6 {

    public static void main(String[] args) {
        String toConvert = "PAYPALISHIRING";
        System.out.println(convert(toConvert,4));
    }

    public static String convert(String s,int numRows){
        if(numRows<=1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]  = new StringBuilder();
        }
        int curRow = 0;
        int diff = 1;
        for(char ch:s.toCharArray()){
            rows[curRow].append(ch);
            if(curRow==numRows-1) diff =-1;
            else if(curRow==0) diff = +1;
            curRow+=diff;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb :rows){
            res.append(sb.toString());
        }
        return res.toString();
    }
}
