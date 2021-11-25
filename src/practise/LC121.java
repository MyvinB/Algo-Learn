package practise;/*
 @author Myvin Barboza
 30/07/20 12:24 PM 
 */

public class LC121 {


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfitKadaneWay(nums));
    }

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


    public static int maxProfitKadaneWay(int[] prices){
        int maxCur= 0,maxSoFar = 0;
        for(int i=1;i<prices.length;i++){
            maxCur = Math.max(0,maxCur += prices[i]-prices[i-1]);
            maxSoFar = Math.max(maxCur,maxSoFar);
        }
        return maxSoFar;
    }

}
