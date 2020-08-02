package LeetCode.String;/*
 @author Myvin Barboza
 02/08/20 10:07 AM 
 */

public class LC520DetectCapital {
    public static void main(String[] args) {

    }
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        if(n==1)
            return true;

        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            for(int i=2;i<word.length();i++){
                if(Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        }
        else {
            for(int i=1;i<word.length();i++){
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }

}
