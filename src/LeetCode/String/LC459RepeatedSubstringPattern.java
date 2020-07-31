package LeetCode.String;/*
 @author Myvin Barboza
 31/07/20 5:25 PM 
 */

public class LC459RepeatedSubstringPattern {

    static boolean repeatedSubstringPattern(String s) {
/*
NOt so fast 106ms
   String str=s+s;
        return str.substring(1,str.length()-1).contains(s);
* */
        int len=s.length();
        for(int i=len/2;i>=1;i--){
            if(len%i==0){
                int num_repeats=len/i;
                String t=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<num_repeats;j++){
                    sb.append(t);
                }
                if(sb.toString().equals(s))return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }


}
