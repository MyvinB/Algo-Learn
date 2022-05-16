package TopicWise2022.Array;

public class LC121 {

    public static void main(String[] args) {
        int[] t = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitKadane(t));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minSoFar = Integer.MAX_VALUE,n= prices.length;
        for(int i=0;i<n;i++){
            minSoFar = Math.min(prices[i],minSoFar);
            maxProfit = Math.max(maxProfit,prices[i]-minSoFar);
        }
        return maxProfit;
    }

    public static int maxProfitKadane(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
