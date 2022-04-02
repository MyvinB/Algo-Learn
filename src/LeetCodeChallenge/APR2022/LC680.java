package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 9:10 AM 4/2/2022
 * Time Taken:
 */
public class LC680 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() -1;
        int dup = 1;
        //"abca"
        while(low<high){
            if(s.charAt(low)==s.charAt(high) || dup-->0){
                low++;
                high--;
            }
            else return false;
        }
        return true;
    }
}
