package TopicWise2022.Array;

public class LC309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int s0 = 0;
        int s1 = -prices[0];
        int s2 = 0;
        for(int i=1;i<n;i++){
            int prevS2 = s2;
            s2 = prices[i]+s1;
            s1 = Math.max(s1, s0-prices[i]);
            s0 = Math.max(s0,prevS2);
        }
        return Math.max(s0,s2);
    }
}
