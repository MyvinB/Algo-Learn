package TopicWise2022.DP.MAXANDMIN;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 6:53 AM 4/8/2022
 * Time Taken:
 */
public class LC871 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        minRefuelStops(100,10,t);
    }

    public static int minRefuelStops(int target, int cur, int[][] s) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; cur < target; res++) {
            while (i < s.length && s[i][0] <= cur)
                pq.offer(-s[i++][1]);
            if (pq.isEmpty()) return -1;
            cur += -pq.poll();
        }
        return res;
    }
}
