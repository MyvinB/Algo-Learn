package LeetCodeChallenge.JUNE2022;

public class LC121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            max = Math.max(max,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return max;
    }
}
