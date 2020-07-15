package LeetCode.String;/*
 @author Myvin Barboza
 15/07/20 1:05 PM 
 */

public class LC151ReverseWordsinaString {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                sb1.append(sb.reverse().toString()+" ");
                sb.setLength(0);
                while(s.charAt(i)==' ')i--;
            }

            sb.append(s.charAt(i));
        }
        sb1.append(sb.reverse().toString());


        return sb1.toString();
    }

}
