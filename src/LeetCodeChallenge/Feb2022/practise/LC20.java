package LeetCodeChallenge.Feb2022.practise;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:59 AM 2/7/2022
 * Time Taken:
 */
public class LC20 {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
               if(!stack.isEmpty() && stack.peek()==map.get(s.charAt(i))){
                   stack.pop();
               } else return false;
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
