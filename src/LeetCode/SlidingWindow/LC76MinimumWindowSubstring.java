package LeetCode.SlidingWindow;
/*
 @author Myvin Barboza
 02/06/20 7:47 AM 
 */

public class LC76MinimumWindowSubstring {

    static String minWindow(String s, String t) {
        int map[]=new int[128];
        //to get the count of t string
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        int lo=0,count=0,minLength=Integer.MAX_VALUE,minStart=-1,minEnd=-1;

        for(int hi=0;hi<s.length();hi++){
            //we found a match increase the count
            if(map[s.charAt(hi)]>0){
                count++;
            }
            // decrease the count in map of already found and if element is not there decrease it will be useful to increase lo pointer
            //also if we already found A in our substring we do not want another copy
            map[s.charAt(hi)]--;
            //count== the count we want
            if(count==t.length()){
                //to move the low pointer to its index
                while(lo<hi &&  map[s.charAt(lo)]<0){
                    map[s.charAt(lo)]++;
                    lo++;
                }
                //to keep count of the minLength so that if we find a smaller windows we update
                if(minLength>hi-lo+1){
                    minLength=hi-lo+1;
                    minStart=lo;
                    //due to substring function
                    minEnd=hi+1;
                }
                //since we are increasing the low pointer to move to the next window we need to increment the value
                //that has been decreased by hi pointer while traversing
                map[s.charAt(lo)]++;
                lo++;
                count--;
            }

        }
        return minStart==-1?"":s.substring(minStart,minEnd);
    }


    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String p="ABC";
        System.out.println(minWindow(s,p));

    }
}