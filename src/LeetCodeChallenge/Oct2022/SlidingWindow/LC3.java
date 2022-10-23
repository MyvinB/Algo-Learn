package LeetCodeChallenge.Oct2022.SlidingWindow;

public class LC3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int lo=0;int start = -1,end =-1;
        int maxLen = 0;
        for(int hi=0;hi<s.length();hi++){
            map[s.charAt(hi)]++;

            while(map[s.charAt(hi)]>1){
                map[s.charAt(lo)]--;
                lo++;
            }
            if(hi-lo+1>maxLen){
                maxLen = hi-lo+1;
            }
        }
        return maxLen;
    }
}
