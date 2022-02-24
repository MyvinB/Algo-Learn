package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 11:09 AM 2/23/2022
 * Time Taken:
 */
public class LC1328 {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aa"));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";
        char[] ar = palindrome.toCharArray();
        int n = palindrome.length();
        for(int i=0;i<n/2;i++){
            if(ar[i]!='a'){
                ar[i] = 'a';
                return String.valueOf(ar);
            }
        }
        ar[n-1] = 'b';
        return n<2? "": String.valueOf(ar) ;
    }
}
