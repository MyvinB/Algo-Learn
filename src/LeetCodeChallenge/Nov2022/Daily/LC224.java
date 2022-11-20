package LeetCodeChallenge.Nov2022.Daily;

import java.util.Stack;

public class LC224 {

    public static void main(String[] args) {
        String p = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(p));

    }

    public static int calculate(String s) {
        int sign = 1;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int curNo = s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    curNo = curNo*10 + s.charAt(i+1)-'0';
                    i++;
                }
                System.out.println(curNo);
                curNo = sign *curNo;
                ans += curNo;
                sign = 1;
            }else if(cur=='+'){
                sign = 1;
            }else if(cur == '-'){
                sign = -1;
            } else if(cur == '('){
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }else if(cur==')'){
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = ans +prevAns;
            }
        }
        return ans;
    }

}
