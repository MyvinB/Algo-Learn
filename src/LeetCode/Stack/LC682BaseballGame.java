package LeetCode.Stack;/*
 @author Myvin Barboza
 25/07/20 10:29 AM 
 */

import java.util.Stack;

public class LC682BaseballGame {
    public static void main(String[] args) {

    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                sum-=stack.pop();
                continue;
            }

            else if(ops[i].equals("D")){
                stack.push(2*stack.get(stack.size()-1));
            }
            else if(ops[i].equals("+"))
                stack.push(stack.get(stack.size()-1)+stack.get(stack.size()-2));
            else{
                stack.push(Integer.valueOf(ops[i]));
            }
            sum+=stack.peek();

        }
        return sum;
    }


}
