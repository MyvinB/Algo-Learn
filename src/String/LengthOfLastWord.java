/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5*/
public class LengthOfLastWord {
    static int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.length()==0) return 0;

        return s.length()-(s.lastIndexOf(" ")+1);


    }


    public static void main(String[] args) {
        String s="World e";
        System.out.println(lengthOfLastWord(s));
    }
}
