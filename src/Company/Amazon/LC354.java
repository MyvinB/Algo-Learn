package Company.Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 10:40 AM 3/30/2022
 * Time Taken:
 */
public class LC354 {
    //
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else return a[0] - b[0];
        });
        int[] tails = new int[envelopes.length];
        int size = 0;
        for(int[] t:envelopes){
            int i =0;
            int j= size;
            while(i<j){
                int mid = i+(j-i)/2;
                if(tails[mid]<t[1]){
                    i = mid+1;
                }else j=mid;
            }
            tails[i]= t[1];
            if(i==size)size++;
        }
        return size;
    }
}
