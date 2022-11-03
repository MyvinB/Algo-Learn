package LeetCodeChallenge.Nov2022.Daily;

import java.util.HashMap;

public class LC2131 {

    public static void main(String[] args) {
        String[] s = new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String[] words) {
        int ans = 0;
        int unpaired = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String w:words){
            if(!map.containsKey(w)) map.put(w,0);
            if(w.charAt(0)==w.charAt(1)){
                if(map.get(w)>0){
                    ans+=4;
                    unpaired--;
                    map.put(w,map.get(w)-1);
                }else {
                    map.put(w,map.get(w)+1);
                    unpaired++;
                }
            }else{
                String rev = (char)w.charAt(1)+""+(char)w.charAt(0)+"";
                if(map.containsKey(rev) && map.get(rev)>0){
                    ans+=4;
                    map.put(rev,map.get(rev)-1);
                }
                else map.put(w,map.get(w)+1);
            }

        }
        if(unpaired>0) ans+=2;
        return ans;
    }
}
