package LeetCodeChallenge.Oct2022.Daily;

public class LC76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        int lo = 0;int start = -1,end= -1;
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        int count= 0;
        int minLen = Integer.MAX_VALUE;
        for(int hi=0;hi<s.length();hi++){
            //if we find the character that was there in t we increment the count
            if(map[s.charAt(hi)]>0){
                count++;
            }
            //Note for duplicates it would decreemnt think BB will only
            // take one time as b will become zero and then next time -1 unless BB is there in t too
            map[s.charAt(hi)]--;

            if(count==t.length()){
                //remove character we do not require as its not there in t string
                //For the one that is there will be exactly zero
                while(lo<hi && map[s.charAt(lo)]<0){
                    map[s.charAt(lo)]++; //bringing the minus to increment it
                    lo++;
                }
                if(minLen>hi-lo+1){
                    start = lo;
                    end = hi;
                    minLen = hi-lo+1;
                }
                map[s.charAt(lo)]++;
                lo++;
                count--;
            }
        }

        return start==-1?"":s.substring(start,end+1);

    }
}
