package Company.MorganStanley;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 6:47 AM 2/22/2022
 * Time Taken:
 */
public class LC20 {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        //()[]{}
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if( stack.isEmpty() || stack.pop()!=map.get(cur)){
                    return false;
                }
            }else{
                stack.push(cur);
            }

        }
        return stack.isEmpty();

    }
}
