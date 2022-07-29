package LeetCodeChallenge.July2022;

public class LC395 {

    public static void main(String[] args) {
//        System.out.println(longestSubstring("ababbc",2));//5'
       System.out.println(longestSubstring("ababacb",3));//0
    }

    public static int longestSubstring(String s, int k) {
        int[] map = new int[128];
        int n = s.length();
        for(int i=0;i<n;i++){
            map[s.charAt(i)]++;
        }
        boolean valid = true;
        int start=0,maxLen=0,end=0;
        for(end=0;end<n;end++){
            if(map[s.charAt(end)]<k ){
                String temp = s.substring(start,end);
                maxLen = Math.max(maxLen,longestSubstring(temp ,k));
                start = end+1;
                valid = false;
            }

        }
        if(valid){
            return n;
        }else {
            return Math.max(maxLen,longestSubstring(s.substring(start),k));
        }
    }
}
