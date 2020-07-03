package CodeForce.C;/*
 @author Myvin Barboza
 03/07/20 9:45 AM 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class C1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t--!=0){
            int n=Integer.parseInt(br.readLine());
            Stack<Character> stack=new Stack<>();
            String p=br.readLine();
            int count=0;
            for (int i = 0; i <n ; i++) {
                if(p.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else if(p.charAt(i)=='(') stack.push('(');
                else {
                  count++;
                }
            }
            System.out.println(count);
        }
    }

}
