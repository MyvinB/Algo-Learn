package LeetCodeChallenge.JAN2022;

import java.util.Locale;

/**
 * @author mmichaelbarboza
 * on 11:22 AM 1/24/2022
 */
public class LC520 {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("GoogLe"));
    }

    public static boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        Boolean isCapital = true;
        Boolean isSmall = true;
        if( word.charAt(0) < 'A' || word.charAt(0)>'Z' ){
            isCapital = false;
        }
        for(int i=1;i<word.length();i++){
            if(word.charAt(i) < 'A' || word.charAt(i)>'Z'){
                isCapital = false;
            }
            if(word.charAt(i) < 'a' || word.charAt(i)>'z'){
                isSmall = false;
            }
        }


        return isCapital || isSmall;
    }
}
