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
        //better
    public String reverseWordsO(String s) {
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(j)==' ') { j--; continue;}

            int i=s.lastIndexOf(' ',j);
            sb.append(s.substring(i+1,j+1));
            j=i-1;
            if(i!=-1)
                sb.append(' ');
        }
        return sb.toString();
    }

}
