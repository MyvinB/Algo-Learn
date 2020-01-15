import java.util.HashMap;
import java.util.Stack;

public class Parentheses {
 

    static boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();;
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack=new Stack<>();

        for (int i = 0; i <s.length() ; i++) {
        char c=s.charAt(i);
        if(mappings.containsKey(c)&&!stack.isEmpty()){
            if(mappings.get(c)==stack.peek())stack.pop();
        }
        else{
            stack.push(c);
        }
        }
        if(stack.isEmpty())return true;
        else return false;
    }


    public static void main(String[] args) {
        Parentheses a=new Parentheses();
        System.out.println(a.isValid("}");
    }
}
