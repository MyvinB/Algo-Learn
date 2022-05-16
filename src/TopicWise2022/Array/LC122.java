package TopicWise2022.Array;

public class LC122 {
        //[7,2,3,7,6,4]
    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        //simple concept ise a notepad and see it solve get the common elements get cancelled
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+= prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
