package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 6:52 PM 12/19/2021
 */
public class LC2108 {

    public static void main(String[] args) {
        String[] s = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(s));
    }

    public static String firstPalindrome(String[] words) {
        int low,high;
        for(String word:words){
            low = 0;
            high = word.length()-1;
            boolean isPalindrome = true;
            while(low<high){
                if(word.charAt(low) != word.charAt(high)){
                    isPalindrome = false;
                    break;
                }
                low++;
                high--;
            }
            if(isPalindrome) return word;

        }

        return "";
    }


}
