package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 3:37 PM 1/26/2022
 */
public class LC387 {

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int a[] = new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(a[s.charAt(i)-'a']==1)return i;
        }
        return -1;
    }
}
