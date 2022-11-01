package LeetCodeChallenge.Nov2022.Revise;

import java.util.Stack;

public class LC32 {

    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int left = -1,max = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                //We are storing the index of the  ) as its invalid and there is nothing to pop from stack
                if(stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if(stack.isEmpty()) max = Math.max(max,i-left); // here we take the last closed bracket position
                    else max = Math.max(max,i-stack.peek()); //here we see first invalid open bracket
                }

            }
        }
        return max;
    }
}


