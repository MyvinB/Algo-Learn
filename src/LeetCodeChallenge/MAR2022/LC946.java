package LeetCodeChallenge.MAR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 8:46 AM 3/16/2022
 * Time Taken:
 */
public class LC946 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i :pushed){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
