package LeetCode.Stack;

import java.util.Stack;

/*
 @author Myvin Barboza
 04/04/20 7:55 AM
 duration :2hours
 */
public class LongestValidParenthesesLC32 {
///)()())
    //()(())
    //()(()

    /*Basically if nothing is in stack use left to find the total length
    if we stored the index in stack then use the index to find the length of the stack
    since it is storing previous values it has an essence of dp to it...
     */
    static int newlongestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int left=-1;
        int max=0;
        for (int i = 0; i <s.length() ; i++) {
            char ch=s.charAt(i);
            if(ch=='(')stack.push(i);
            else{
                //consider the test case ")()" here the value left index should start from one this is done for that
                if(stack.isEmpty())left=i;
                else {
                    stack.pop();
                    //()() left is ie initialsed at -1
                    if(stack.isEmpty())max =Math.max(max,i-left);
                    //()(()
                    else max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(newlongestValidParentheses("()(()"));
    }

}