package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 7:38 AM 2/22/2022
 * Time Taken:
 */
public class LC121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            profit = Math.max(profit,prices[i]-minSoFar);
            if(prices[i]<minSoFar){
                minSoFar = prices[i];
            }
        }
        return profit;
    }
}
