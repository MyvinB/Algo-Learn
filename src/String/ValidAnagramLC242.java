package String;

/*
 @author Myvin Barboza
 18/04/20 1:29 PM 
 */
public class ValidAnagramLC242 {

    static boolean isAnagram(String s, String t) {
        int a[]=new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            a[t.charAt(i)-'a']--;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a","b"));

    }
}