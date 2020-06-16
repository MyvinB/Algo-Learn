package LeetCode.String;/*
 @author Myvin Barboza
 16/06/20 4:51 PM 
 */

public class LC468ValidateIPAddress {


    static boolean ipv4(String s){
        int count=0;
        for(int i=0;i<s.length();i++)if(s.charAt(i)=='.')count++;
        if(count!=3) return false;
        String ar[]=s.split("\\.");
        if(ar.length!=4) return false;
        for(String p: ar){
            if(p.isEmpty()||p.length()>3) return false;
            for(int i=0;i<p.length();i++)if(!Character.isDigit(p.charAt(i))) return false;

            int num=Integer.parseInt(p);
            /// to check for trailing zero 0001 and 1
            if(!String.valueOf(num).equals(p) || num<0 ||  num>255)
                return false;
        }
        return true;
    }

    static boolean ipv6(String s){
        int count=0;
        for(int i=0;i<s.length();i++)if(s.charAt(i)==':') count++;
        if(count!=7) return false;
        String ar[]=s.split("\\:");
        if(ar.length!=8) return false;
        for(String p: ar){
            if(p.isEmpty()||p.length()>4) return false;
            for(int i=0;i<p.length();i++)
                // hexadeciimal digits are represented by A F which is 10 to 15
                // we are only including them and checking is the character is a digit
                if(!Character.isDigit(p.charAt(i)) && (p.charAt(i)<'A' || p.charAt(i)>'F' ))return false;
        }
        return true;
    }



    static String validIPAddress(String IP) {
        if(ipv4(IP)) return "IPv4";
        else if(ipv6(IP.toUpperCase())) return "IPv6";
        else return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:7334"));
    }


}
