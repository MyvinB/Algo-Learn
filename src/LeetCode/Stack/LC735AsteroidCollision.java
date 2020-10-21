package LeetCode.Stack;/*
 @author Myvin Barboza
 21/10/20 5:59 PM 
 */

import java.util.Arrays;
import java.util.Stack;

public class LC735AsteroidCollision {
    public static void main(String[] args) {
        int asteroids[] = { 10, 2,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));

    }

    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int ast :asteroids){
            if(ast>0){
                stack.push(ast);
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(ast)){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0)
                    stack.push(ast);
                else if(stack.peek()+ast == 0){
                    stack.pop();
                }
            }
        }

        int res[] = new int[stack.size()];
        for (int i = res.length-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;

    }

}
