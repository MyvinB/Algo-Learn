package LeetCodeChallenge.July2022;

public class LC424 {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",2));
    }

    public static int characterReplacement(String s, int k) {
        int[] map = new int[128];
        int start=0;
        int maxLetter = 0;
        int maxLen = 0;
        for(int eo=0;eo<s.length();eo++){
            maxLetter = Math.max(maxLetter,++map[s.charAt(eo)]);
            //See if we crossed the letter replacement benefit if so decrease the window
            //we do not bother with maxCoutn say we found something bing enogh why bother with anything less it might be an invalid case sometimes but we found something big and valid already
            while(eo-start+1-maxLetter>k){
                map[s.charAt(start)]--;
                start++;
            }
            maxLen = Math.max(maxLen,eo-start+1);
        }
        return maxLen;
    }
}
