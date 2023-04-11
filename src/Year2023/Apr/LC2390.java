package Year2023.Apr;

import java.util.Stack;

public class LC2390 {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur=='*' && !stack.isEmpty()){
                stack.pop();
            }else stack.push(cur);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
