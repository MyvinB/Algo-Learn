package LeetCode.DP;
/*
 @author Myvin Barboza
 09/06/20 12:47 PM 
 */

public class LC392IsSubsequence {

    static boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int e=0,f=0;
        while(f<t.length()){
            if(s.charAt(e)==t.charAt(f)){
                e++;
                if(e==s.length()) return true;
            }
            f++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}