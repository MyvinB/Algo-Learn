import java.util.LinkedList;

public class MyAtoi {
    static int myAtoi(String str) {
        int i=0,r=0;
        int sign=1;
        str = str.trim();
        if (str.isEmpty()) return 0;
        else if (str.charAt(i) == '-') { i++; sign = -1; }
        else if (str.charAt(i) == '+') { i++; }
        while(i<str.length()&&Character.isDigit(str.charAt(i))){
            int d=str.charAt(i)-'0';
            if(r>(Integer.MAX_VALUE-d)/10) return sign >0? Integer.MAX_VALUE:Integer.MIN_VALUE;
            r=r*10+d;
            i++;
        }
        return r*sign;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("77777777777777777777777777777777777777777777777777"));
        //String temp="23334";
        //System.out.println(temp.indexOf("3334"));
       // System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
    }
}
