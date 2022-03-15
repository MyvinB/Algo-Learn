package LeetCodeChallenge.MAR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 8:52 AM 3/15/2022
 * Time Taken:
 */
public class LC1249 {
    public static void main(String[] args) {

    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(i);
            else if(s.charAt(i)==')'){
                if(stack.isEmpty()) sb.setCharAt(i,'*');
                else stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'*');
        }

        return sb.toString().replace("\\*","");
    }
}
