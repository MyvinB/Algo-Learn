package LeetCodeChallenge.MAY2022;

import java.util.Stack;

public class LC32LongestValidParentheses {

    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        //left gives you the previous  wrong pattern  index so that you can find it out for ')'
        //if it is in the stack its the wrong pattern for '('
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(i);
            else{
                if(stack.isEmpty()) left = i;
                else{
                    stack.pop();
                    if(stack.isEmpty())
                        max = Math.max(max,i-left);
                    else{
                        max = Math.max(max,i-stack.peek());
                    }

                }
            }
        }
        return max;
    }
}
