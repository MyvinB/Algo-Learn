package String;/*
 @author Myvin Barboza
 3/9/2020 11:26 AM
 */
//the first string matter to us not the second we count the number of required character is first that are not there in the second
public class MakeTwoStringsAnagramLC1347 {
    static int minSteps(String s, String t) {
        int count=0;
        int sa[]=new int[26];
        int ta[]=new int[26];
        for(int i=0;i<s.length();i++){
            sa[s.charAt(i)-'a']++;
            ta[t.charAt(i)-'a']++;
        }
        for(int i=0;i<sa.length;i++){
            sa[i]=sa[i]-ta[i];
        }
        for(int i=0;i<sa.length;i++){
            if(sa[i]>0)count=count+sa[i];
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(minSteps("leetcode","practice"));
    }
}
