package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 21/12/20 12:08 PM 
 */

public class LC880DecodedStringAtIndex {

    public static void main(String[] args) {
    String s = "leet2code3";
    String p = "a23";
        System.out.println(decodeAtIndex(p,6));
    }

    static String decodeAtIndex(String S, int K) {
    long size=0;
    int n = S.length();
    for (char s:S.toCharArray()){
        if(Character.isDigit(s))
            size=size*(s-'0');
        else
            size++;
    }

    for(int i=n-1; i>=0;i--){
        char ch = S.charAt(i);
        if((K == size|| K == 0) && Character.isLetter(ch)){
            return ch+"";
        }
        else if (Character.isDigit(ch)) {
            size /=(ch- '0');
            K %= size;
        }
        else {
            size--;
        }

    }
        return null;
    }

}
