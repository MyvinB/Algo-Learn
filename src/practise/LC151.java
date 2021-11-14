package practise;

import java.util.Stack;

public class LC151 {
    public static void main(String[] args) {
        System.out.println("a".substring(0,1));
        reverseWords("F R  I   E    N     D      S      ");
    }
    public static String reverseWords(String s) {
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
