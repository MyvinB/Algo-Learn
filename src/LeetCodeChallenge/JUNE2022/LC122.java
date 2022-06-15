package LeetCodeChallenge.JUNE2022;

public class LC122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0) profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
