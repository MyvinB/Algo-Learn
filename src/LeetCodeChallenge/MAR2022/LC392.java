package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 6:48 AM 3/2/2022
 * Time Taken:
 */
public class LC392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("b","abc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        if(s.length()==0) return true;
        int countSeq = 0;
        while(j<t.length() && i<s.length()){
           if(s.charAt(i)==t.charAt(j)){
               countSeq++;
               i++;j++;
           }else{
               j++;
           }
        }
        if(s.length()==countSeq) return true;
        else return false;
    }
}
