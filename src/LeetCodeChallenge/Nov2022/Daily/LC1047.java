package LeetCodeChallenge.Nov2022.Daily;

import java.util.Stack;

public class LC1047 {

    public static void main(String[] args) {

    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(Character p:stack) sb.append(p);
        return sb.toString();
    }
}
