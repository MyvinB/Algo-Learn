package LeetCodeChallenge.JUNE2022;

public class LC8 {

    public static void main(String[] args) {
        myAtoi(" ");
    }

    public static int myAtoi(String s) {
        int total = 0;
        int i=0,sign = 1;
        int n = s.length();
        //1 Check if string is empty
        if(s.length()==0) return total;
        //2 Skip empty spaces
        while(i<n && s.charAt(i)==' ' ) i++;

        if(i==n) return total;
        //3 Check for sign to use later
        if(s.charAt(i)=='-') {i++;sign = -1;}
        else if(s.charAt(i)=='+'){i++; sign = 1;}
        while(i<n){
            int digit = s.charAt(i)-'0';
            if(digit<0 || digit>9) break;
            if((Integer.MAX_VALUE-digit)/10<total) {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total = total*10+digit;
            i++;
        }
        return total*sign;
    }
}
