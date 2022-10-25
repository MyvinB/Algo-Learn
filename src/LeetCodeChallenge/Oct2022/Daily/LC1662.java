package LeetCodeChallenge.Oct2022.Daily;

public class LC1662 {

    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb.append(word1[i]);
        }
        String temp = sb.toString();
        sb = new StringBuilder();
        for(int i=0;i<word2.length;i++){
            sb.append(word2[i]);
        }
        return temp.equals(sb.toString())?true:false;

    }
}
