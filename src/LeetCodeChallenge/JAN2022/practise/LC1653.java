package LeetCodeChallenge.JAN2022.practise;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 12:33 PM 1/24/2022
 */
public class LC1653 {

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
    }

    public static int minimumDeletions(String s) {
        Stack<Character> stack  = new Stack<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()>cur){
                res++;
                stack.pop();
            }else stack.push(cur);
        }
        return res;
    }
}
