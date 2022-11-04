package LeetCodeChallenge.Nov2022.Daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LC345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        char sCharArr[] = s.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add('a');list.add('A');
        list.add('e');list.add('E');
        list.add('i');list.add('I');
        list.add('o');list.add('O');
        list.add('u');list.add('U');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(list.contains((char)s.charAt(i))){
                stack.push(s.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++){
            if(list.contains((char)s.charAt(i))){
                sCharArr[i] = stack.pop();
            }
        }
        return new String(sCharArr);
    }
}
