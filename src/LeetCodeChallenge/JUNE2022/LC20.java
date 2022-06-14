package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;
import java.util.Stack;

public class LC20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(!stack.isEmpty() && stack.peek()==map.get(cur)){
                    stack.pop();
                }else return false;
            }else stack.push(cur);
        }
        return stack.isEmpty();
    }
}
