package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 8:32 AM 4/8/2022
 * Time Taken:
 */
public class LC983 {

    public static void main(String[] args) {

    }

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        boolean isTravelDay[] = new boolean[lastDay+1];
        for(int i=0;i<days.length;i++){
            isTravelDay[days[i]] = true;
        }
        for(int i=0;i<=lastDay;i++){
            if(!isTravelDay[i]){
                //we copy over the values to the next element cause dp[i-1[ should have the precalculated values of the previous travlled day.
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = costs[0] +dp[i-1];
            dp[i] = Math.min(dp[Math.max(i-7,0)]+costs[1],dp[i]);
            dp[i] = Math.min(dp[Math.max(i-30,0)]+costs[2],dp[i]);
        }
        return dp[lastDay];
    }
}
