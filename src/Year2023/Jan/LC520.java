package Year2023.Jan;

public class LC520 {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
        System.out.println(detectCapitalUse("G"));
        System.out.println(detectCapitalUse("mL"));
    }

    public static boolean detectCapitalUse(String word) {
        boolean anySmall = false;
        boolean anyCaps = false;
        boolean firstCaps = false;
        if(word.length()!=0 && word.charAt(0)>=65 && word.charAt(0)<=90) firstCaps = true;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)>=65 && word.charAt(i)<=90){
               anyCaps = true;
            }
            else if(word.charAt(i)>=97 && word.charAt(i)<=122){
                anySmall = true;
            }
        }
        if(anyCaps && !anySmall && firstCaps) return true;
        if(anySmall && !anyCaps) return true;
        if(!anySmall && !anyCaps) return true;
        return false;
    }
}
