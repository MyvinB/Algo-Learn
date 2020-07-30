package practise;/*
 @author Myvin Barboza
 30/07/20 12:24 PM 
 */

public class LC121 {

    public int maxProfit(int[] prices) {
        if(prices.length==0|| prices.length==1) return 0;
        int b1=-prices[0];
        int s1=0;
        for(int i=0;i<prices.length;i++){
            s1=Math.max(s1,prices[i]+b1);
            b1=Math.max(b1,-prices[i]);


        }
        return s1;
    }

}
