package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:55 AM 2/7/2022
 * Time Taken:
 */
public class LC242 {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] A = new int[26];
        for(int i=0;i<s.length();i++){
            A[s.charAt(i)-'a']++;
            A[t.charAt(i)-'a']--;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=0) return false;
        }
        return true;
    }
}
