package LeetCodeChallenge.MAR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 8:35 AM 3/19/2022
 * Time Taken:
 */
public class LC316 {

    public static void main(String[] args) {

    }
    public String removeDuplicateLetters(String s) {
        int lastSeenIndex [] = new int[26];
        for(int i=0;i<s.length();i++){
            lastSeenIndex[s.charAt(i)-'a'] = i;
        }
        boolean seen[] = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            int cur = s.charAt(i)-'a';
            if(seen[cur])continue;
            //checks if cur character is lexographically smaller if so it pops the element in the stack if and only if the prev character exist in the string
            while(!stack.isEmpty() && stack.peek()>cur && i<lastSeenIndex[stack.peek()]){
                seen[stack.pop()] =false;
            }
            stack.push(cur);
            seen[cur] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int p:stack){
            sb.append((char)(p+'a'));
        }
        return sb.toString();

    }
}
