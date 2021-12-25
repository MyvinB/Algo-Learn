package LeetCodeChallenge.December2021;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 7:45 PM 12/25/2021
 */
public class LC227 {
    public static void main(String[] args) {
        String s = "2+3/2+5";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int len = s.length();
        if(s==null) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) || i==len-1 ){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                num=0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        for(int i:stack){
            res+= i;
        }
        return res;
    }
}
