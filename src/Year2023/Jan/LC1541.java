package Year2023.Jan;

import java.util.Stack;

public class LC1541 {

    public static void main(String[] args) {
        String s = "(()))";
        String p = "())";
        String t = "))())(";
        String f = ")))))))";
        String g = "()";
        System.out.println(minInsertions(g));
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                if(!stack.isEmpty() && stack.peek()==')'){
                    ans++;
                    stack.pop();
                    stack.pop();
                }
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    ans++;
                    stack.push('(');
                    stack.push(ch);
                }else{
                    if(stack.peek()==')'){
                        stack.pop();
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }
            }
        }
        if(stack.isEmpty()) return ans;
        else {
            while(!stack.isEmpty()){
                char ch = stack.pop();
                if(ch=='(') ans+=2;
                else {
                    ans+=1;
                    stack.pop();
                }
            }
            return ans;
        }
    }

}
