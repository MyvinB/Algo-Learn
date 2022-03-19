package LeetCodeChallenge.MAR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:12 AM 3/17/2022
 * Time Taken:
 */
public class LC856 {

    public static void main(String[] args) {

    }

    //O(n) space
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(score);
                score = 0;
            }else {
                score = stack.pop() +Math.max(score*2,1);
            }
        }
        return score;
    }

    public int scoreOfParenthesis(String s){
        int level = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') level++; else level--;
            if(s.charAt(i) == ')' && s.charAt(i-1)== '(') res += Math.pow(2,level);
        }
        return res;
    }
}
