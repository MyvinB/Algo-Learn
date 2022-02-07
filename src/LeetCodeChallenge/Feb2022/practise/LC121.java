package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:49 AM 2/7/2022
 * Time Taken:
 */
public class LC121 {
    public static void main(String[] args) {
        int t[] = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(t));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]-min>maxProfit){
                maxProfit = prices[i]-min;
            }
            min = Math.min(prices[i],min);
        }
        return maxProfit;
    }
}
