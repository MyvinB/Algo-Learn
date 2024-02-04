package Year2024.Feb;

public class LC76 {

    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int start = -1,end=-1,minWindowLen = 0,lo=0,count=0;
        int[] map = new int[128];
        //Filling the map with t string
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }

        for(int hi=0;hi<s.length();hi++){

            if(map[s.charAt(hi)]>0){
                count++;
            }
            map[s.charAt(hi)]--;
            if(count==t.length()){
                //We do not want characters in our string that are not present in t so we eliminate them
                while(lo<hi && map[s.charAt(lo)]<0){
                    //increment it back
                    map[s.charAt(lo)]++;
                    lo++;
                }

                if(minWindowLen<hi-lo+1){
                    start = lo;
                    end = hi;
                    minWindowLen = start-end+1;
                }
                map[s.charAt(lo)]++;
                lo++;
                count--;
            }
        }

        return start==-1?"":s.substring(start,end+1);
    }
}
