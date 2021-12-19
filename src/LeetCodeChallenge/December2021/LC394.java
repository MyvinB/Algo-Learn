package LeetCodeChallenge.December2021;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 6:29 PM 12/19/2021
 */
public class LC394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
     String res =  "";
     Stack<Integer> countStack = new Stack<>();
     Stack<String> resStack = new Stack<>();
     int idx = 0;
     int len = s.length();
     while(idx<len){
         if(Character.isDigit(s.charAt(idx))){
             int count =0;
             while(Character.isDigit(s.charAt(idx))){
                 count = count*10 +s.charAt(idx) -'0';
                 idx++;
             }
             countStack.push(count);
         }else if(s.charAt(idx) == '['){
             resStack.push(res);
             res = "";
             idx++;
         }else if(s.charAt(idx) == ']'){
             StringBuilder sb = new StringBuilder(resStack.pop());
             int repeat = countStack.pop();
             for(int i =0;i<repeat;i++){
                 sb.append(res);
             }
             res = sb.toString();
             idx++;
         }else {
             res += s.charAt(idx++);
         }

     }
     return res;
    }
}
