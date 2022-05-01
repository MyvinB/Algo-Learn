package LeetCodeChallenge.MAY2022;

import java.util.Stack;

public class LC844BackspaceStringCompare {

    public static void main(String[] args) {


        String s =  "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompareOpti(s,t));
    }


    //Naive O(n) o(n) space
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!stack1.isEmpty())
                    stack1.pop();
            }
            else {
                stack1.add(s.charAt(i));
            }
        }

        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(!stack2.isEmpty())
                    stack2.pop();
            }
            else{
                stack2.add(t.charAt(i));
            }
        }
        if(stack1.size()!=stack2.size()) return false;
        int i = 0;
        int size = stack1.size();
        while(i<size){
            i++;
            if(stack1.pop()!=stack2.pop()) return false;
            System.out.println(i);
        }
        return true;

    }

    public static boolean backspaceCompareOpti(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        while(i>=0 || j>=0){
            int decreI = 0;
            while(i>=0 && (s.charAt(i)=='#' || decreI>0 )){
                if(s.charAt(i)=='#') decreI++;
                else decreI--;
                i--;
            }
            int decreJ = 0;
            while(j>=0 && (t.charAt(j)=='#' || decreJ>0)){
                if(t.charAt(j)=='#') decreJ++;
                else decreJ--;
                j--;
            }
            if(i>=0 && j>=0 && s.charAt(i) == t.charAt(j)){
                i--;j--;
            }else return i==-1 && j==-1;

        }
        return true;
    }
}
