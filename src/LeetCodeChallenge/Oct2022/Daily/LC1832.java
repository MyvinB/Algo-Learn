package LeetCodeChallenge.Oct2022.Daily;

public class LC1832 {

    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        int[] t = new int[26];
        for(int i=0;i<n;i++){
            t[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(t[i]==0) return false;
        }
        return true;
    }
}
