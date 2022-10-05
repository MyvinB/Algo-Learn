package LeetCodeChallenge.Oct2022.Stack;

import java.util.Stack;

public class LC32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       int left = -1;int max= 0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='(') stack.push(i);
           else {
               if(stack.isEmpty()) left = i; //we found our unbalnace and we store the start index
               else{
                   stack.pop(); //poping valid solutions from the stack an
                   if(stack.isEmpty()) max = Math.max(max,i-left); //Getting last index of unvalid )
                   else max = Math.max(max,i-stack.peek());//Getting last index of unvalid (
               }
           }
       }
       return max;
    }
}
