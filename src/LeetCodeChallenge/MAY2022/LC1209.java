package LeetCodeChallenge.MAY2022;

import java.util.Stack;

public class LC1209 {

    public static void main(String[] args) {

    }

    //Stack
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0]==ch){
                stack.peek()[1]++;
            } else stack.push(new int[]{ch,1});
            if(stack.peek()[1]==k) stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            while(top[1]-->0){
                sb.append((char)top[0]);
            }
        }

        return sb.reverse().toString();
    }

    //twoPointer
    public String removeDuplicatesTp(String s, int k) {
      int i = 0,n = s.length(),count[] = new int[n];
      char[] stack = s.toCharArray();
      for(int j=0;j<n;j++,i++){
        stack[i] = stack[j];
        count[i] = i>0 && stack[i-1] == stack[j]?count[i-1]+1:1;
        if(count[i]==k) i -=k;
      }
      return new String(stack,0,i);
    }
}
