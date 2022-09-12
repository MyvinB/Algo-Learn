package LeetCodeChallenge.Sep2022.DpPractise.Stock;

public class LC121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;
    }
}
