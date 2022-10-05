package LeetCodeChallenge.Oct2022.Stack;

import java.util.Stack;

public class LC316RemoveDuplicateLetters {


    public static void main(String[] args) {

    }

    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            int cur =s.charAt(i)-'a';
            if(seen[cur]) continue;
            //checks if cur character is lexographically smaller if so it pops the element in the stack if and only if the prev character exist in the string
            while(!stack.isEmpty() && stack.peek() >cur  && i<last[stack.peek()]){
                seen[stack.pop()] = false;
            }
            stack.push(cur);
            seen[cur] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i:stack){
            sb.append((char)(i+'a'));
        }
        return sb.toString();
    }
}
