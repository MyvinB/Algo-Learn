package LeetCodeChallenge.APR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:32 AM 4/10/2022
 * Time Taken:
 */
public class LC682 {

    public static void main(String[] args) {
        String[] t = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(t));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0;i<ops.length;i++){
            if(ops[i] == "C"){
                stack.pop();
            }
            else if(ops[i]== "D"){
                stack.push(stack.peek()*2);
            }
            else if(ops[i] == "+"){
                int prev1 = stack.pop();
                int newEl = prev1 + stack.peek();
                stack.push(prev1);
                stack.push(newEl);
            }
            else stack.push(Integer.parseInt(ops[i]));
        }
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;

    }
}
