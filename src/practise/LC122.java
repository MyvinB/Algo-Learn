package practise;/*
 @author Myvin Barboza
 30/07/20 12:08 PM 
 */

public class LC122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int b1=-prices[0];
        int b0=b1,s0=0,s1=0;
        for(int i=1;i<prices.length;i++){
            b0=Math.max(b1,s0-prices[i]);
            s0=Math.max(s0,b1+prices[i]);
            b1=b0;

        }
        return s0;

    }
}
