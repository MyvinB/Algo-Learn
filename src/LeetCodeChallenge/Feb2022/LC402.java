package LeetCodeChallenge.Feb2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:39 AM 2/19/2022
 * Time Taken:
 */
public class LC402 {
    public static void main(String[] args) {
        removeKdigits("10",2);
    }

    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<num.length()){
            while(!stack.isEmpty() && stack.peek()>Integer.parseInt(num.charAt(i)+"") && k>0 ){
                stack.pop();
                k--;
            }
            stack.push(Integer.parseInt(num.charAt(i)+""));
            i++;
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        i=0;
        while(i<sb.length() && sb.charAt(i) == '0'){
            i++;
        }
        return sb.substring(i).toString().equals("")?"0":sb.substring(i).toString();
    }
}
