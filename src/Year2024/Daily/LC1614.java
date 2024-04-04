package Year2024.Daily;

import java.util.Stack;

public class LC1614 {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
                max = Math.max(max,count);
            }
            else if(ch==')'){
                count--;
            }
        }
        return max;
    }
}
