package String;

import java.util.Stack;

/*
 @author Myvin Barboza
 18/03/20 3:09 PM 
 */
public class AddStringLC415 {
    static String addStrings(String num1, String num2) {
        int res=0;
        int carry=0;
        StringBuilder result=new StringBuilder();
        Stack<Integer> a=new Stack<>();
        Stack<Integer> b=new Stack<>();
        for(int i=0;i<num1.length();i++)a.add(num1.charAt(i)-'0');
        for(int i=0;i<num2.length();i++)b.add(num2.charAt(i)-'0');
        while(true){
            if(a.isEmpty()&& b.isEmpty()){
                if(carry!=0)
                result.append(carry);
                break;
            }
            int a1=a.isEmpty()?0:a.pop();
            int b1=b.isEmpty()?0:b.pop();
            res=a1+b1+carry;
            carry=0;
            if(res>9){
                carry=res/10;
                result.append(Integer.toString(res%10));
            }
            else{
                result.append(Integer.toString(res));
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("408","5"));

    }
}