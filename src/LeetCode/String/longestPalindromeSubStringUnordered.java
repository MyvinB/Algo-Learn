package LeetCode.String;/*
 @author Myvin Barboza
 31/03/20 7:38 PM 
 */



import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class longestPalindromeSubStringUnordered {

    static String longestPalindrome(String str)
    {
        // create a frequency map for characters of given String
        Map<Character, Integer> freq = new TreeMap<>();
        for (char ch: str.toCharArray()) {
            freq.putIfAbsent(ch, 0);
            freq.put(ch, freq.get(ch) + 1);
        }

        Character mid_char = null;					// stores odd character
        StringBuilder left = new StringBuilder();	// stores left substring

        // iterate through the frequency map
        for (Map.Entry<Character, Integer> p: freq.entrySet())
        {
            char ch = p.getKey();		// get current character
            int count = p.getValue();	// get character frequency

            // if the frequency of current character is odd
            // update mid to current char (and discard old one)
            if (count % 2 == 1) {
                mid_char = ch;
            }

            // append half of the characters to the left substring
            // (other half goes to the right substring in reverse order)
            for (int i = 0; i < count/2; i++) {
                left.append(ch);
            }
        }

        // right substring will be reverse of left substring
        String right = new StringBuilder(left).reverse().toString();

        // return String formed by the left substring, mid character (if any)
        // and the right substring
        return (left.toString() + mid_char + right);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("adskassda"));
    }
}
