package LeetCode.BitWiseAlgo;/*
 @author Myvin Barboza
 24/09/20 4:45 PM 
 */

public class LC389FindtheDifference {

    public static void main(String[] args) {

    }


    public char findTheDifference(String s, String t) {
//        int letter[]=new int[26];
//        for(int i=0;i<s.length();i++){
//            letter[s.charAt(i)-'a']++;
//            letter[t.charAt(i)-'a']--;
//        }
//        letter[t.charAt(t.length()-1)-'a']--;
//        for(int i=0;i<26;i++){
//            if(letter[i]!=0) {
//                System.out.println(i);
//                return (char)(i+'a');
//            }
//
//        }
//        return 'a';
    //// oro do it using xor simple don't even need to take the array jusr charcode

        int charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
            charCode -= (int)s.charAt(i);
            charCode += (int)t.charAt(i);
        }
        return (char)charCode;
    }
}
