package LeetCode.Stack;
/*
 @author Myvin Barboza
 19/05/20 4:53 PM 
 */

import java.util.Stack;

public class LC150EvaluateReversePolishNotation {


   static int evalRPN(String[] tokens) {

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s!="+" && s!="-" && s!="*" && s!="/"){
                stack.add(Integer.parseInt(s));
            }
            else {

                int b=!stack.isEmpty()?stack.pop() :0;
                int a=!stack.isEmpty()?stack.pop():0;
                int c=0;
                if(s.equals("+"))c=a+b;
                if(s.equals("-"))c=a-b;
                if(s.equals("*"))c=a*b;
                if(s.equals("/"))c=a/b;
                stack.push(c);

            }

        }

        return stack.pop();

    }

    public static void main(String[] args) {
    String token[]={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(token));
}

}

