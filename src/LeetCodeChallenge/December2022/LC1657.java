package LeetCodeChallenge.December2022;

import java.util.Arrays;

public class LC1657 {


    public static void main(String[] args) {

    }

    public boolean closeStrings(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for(int i=0;i<word1.length();i++) w1[word1.charAt(i)-'a']++;
        for(int i=0;i<word2.length();i++) w2[word2.charAt(i)-'a']++;
        //A basic check to see if there is any letter in word 1 that is not there in word2 or vice versa
        for(int i=0;i<26;i++){
            if(w1[i]==w2[i]) continue;
            if(w1[i]==0 || w2[i]==0) return false;
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        for(int i=0;i<26;i++){
            if(w1[i]!=w2[i]) return false;
        }
        return true;
    }
}
