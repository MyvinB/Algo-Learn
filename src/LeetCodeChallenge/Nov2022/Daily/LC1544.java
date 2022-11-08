package LeetCodeChallenge.Nov2022.Daily;

import java.util.Stack;

public class LC1544 {

    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }

    public static String makeGood(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(s.charAt(stack.peek())-s.charAt(i))==32){
                stack.pop();
            }else stack.push(i);
        }
        char[] res = new char[stack.size()];
        int idx = stack.size()-1;
        while(!stack.isEmpty()){
            res[idx--] = s.charAt(stack.pop());
        }
        return new String(res);
    }
}
