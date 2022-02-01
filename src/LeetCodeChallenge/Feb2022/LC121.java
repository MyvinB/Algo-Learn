package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 9:36 AM 2/1/2022
 * Time Taken : 05 : 45
 */
public class LC121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            if(prices[i]-min>maxProfit) maxProfit = prices[i]-min;
        }
        return maxProfit;
    }
}
