package LeetCodeChallenge.July2022;

public class LC121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            max = Math.max(max,prices[i]-minSoFar);
        }
        return max;
    }
}
