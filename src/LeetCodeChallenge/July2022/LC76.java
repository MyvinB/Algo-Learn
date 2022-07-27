package LeetCodeChallenge.July2022;

public class LC76 {

    public static void main(String[] args) {
        String s = "a";
        String p = "aa";
        System.out.println(minWindow(s,p));
    }

    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for(int i = 0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        int lo=0,minLen = Integer.MAX_VALUE,start = -1,end = -1;
        int count = 0;
        for(int hi=0;hi<s.length();hi++){
            if(map[s.charAt(hi)]>0){
                count++;
            }
            map[s.charAt(hi)]--;
            if(count==t.length()){
                //Move the unwanted characters so we can get min string as the wanted one will be zero
                while(lo<hi && map[s.charAt(lo)]<0){
                    map[s.charAt(lo)]++;
                    lo++;
                }
                if(minLen>hi-lo+1){
                    minLen = hi-lo+1;
                    start = lo;
                    end =hi+1;
                }
                map[s.charAt(lo)]++;
                lo++;
                count--;
            }
        }
        return start==-1?"":s.substring(start,end);
    }
}
