package TopicWise2022.SlidingWindow;

/**
 * @author mmichaelbarboza
 * on 3:45 PM 4/1/2022
 * Time Taken:
 */
public class LC76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        int lo=0,count=0,minLength = Integer.MAX_VALUE,minStart = -1, minEnd = -1;
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        for(int hi=0;hi<s.length();hi++){
            if(map[s.charAt(hi)]>0){
                count++;
            }
            map[s.charAt(hi)]--;
            if(count == t.length()){
                //Move low pointer till we have the substring
                while(lo<hi && map[s.charAt(lo)]<0){
                    map[s.charAt(lo)]++;
                    lo++;
                }
                if(minLength>hi-lo+1){
                    minLength = hi-lo+1;
                    minStart = lo;
                    minEnd = hi+1;
                }
                map[s.charAt(lo)]++;
                lo++;
                count--;
            }
        }

        return minStart==-1?"":s.substring(minStart,minEnd);
    }
}
