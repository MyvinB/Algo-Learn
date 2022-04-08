package TopicWise2022.DP.MAXANDMIN;

import java.util.PriorityQueue;
import java.util.Queue;

/**+
 * @author mmichaelbarboza
 * on 6:53 AM 4/8/2022
 * Time Taken:
 */
public class LC871 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        minRefuelStops(100,10,t);
    }
    //DP O(n2)
    public static int minRefuelStops(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length+1];
        dp[0] = startFuel;
        for(int i=0;i<s.length;i++){
            //dp[t]>=s[i][0] signifies we have enough petrol to reach spot
            for(int t=i;t>=0 && dp[t]>=s[i][0];t--){
                dp[t+1] = Math.max(dp[t+1],dp[t]+s[i][1]);
            }
        }
        for(int i=0;i<=s.length;i++){
            if(dp[i]>=target) return i;
        }
        return -1;
    }

    //PriorityQueue nlogn
    public static int minRefuelStopsPq(int target, int startFuel, int[][] s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long cur = startFuel;
        int i= 0;
        int res = 0;
        for(res = 0;cur<target;res++){
            while(i<s.length && cur>=s[i][0]){
                pq.add(-s[i++][1]);
            }
            if(pq.isEmpty()) return -1;
            cur += -pq.poll();
        }
        return res;
    }


}
