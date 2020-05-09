package LeetCode.String;

import java.util.Stack;

/*
 @author Myvin Barboza
 16/04/20 4:25 PM 
 */
public class ValidParenthesisStringLC678 {
///((()))****
    static boolean checkValidString(String s) {
        int cmin=0;
        int cmax=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <s.length() ; i++) {
                if(s.charAt(i)=='('){
                    cmin++;
                    cmax++;
                }else if(s.charAt(i)==')'){
                    cmin--;
                    cmax--;
                }
                else{
                    cmax++;
                    cmin--;
                }

            if(cmax<0) return false;
            cmin=Math.max(cmin,0);
        }

        return cmin==0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString(""));
    }
}