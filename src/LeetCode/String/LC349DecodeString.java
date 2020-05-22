package LeetCode.String;
/*
 @author Myvin Barboza
 22/05/20 6:37 AM 
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC349DecodeString {

    static String decodeString(String s) {
        Deque<Integer> counts=new ArrayDeque<>();
                Deque<StringBuilder> result=new ArrayDeque<>();
        StringBuilder res=new StringBuilder() ;
        int index=0;

        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count=0;
                while(Character.isDigit(s.charAt(index))){
                    count=10*count+(s.charAt(index)-'0');
                            index++;
                }
                counts.addLast(count);

            }else if(s.charAt(index)=='['){
                result.addLast(res);
                res=new StringBuilder();
                index++;
            }else if(s.charAt(index)==']'){
                StringBuilder temp=new StringBuilder(result.pollLast());
                int count=counts.pollLast();
                for (int i = 0; i <count ; i++) {
                    temp.append(res);
                }
                res=temp;
                index++;
            }else{
                res.append(s.charAt(index));
                index++;
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}