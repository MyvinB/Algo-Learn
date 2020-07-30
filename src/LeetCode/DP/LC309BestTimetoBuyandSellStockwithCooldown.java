package LeetCode.DP;/*
 @author Myvin Barboza
 30/07/20 8:31 AM 
 */

public class LC309BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {

    }


    /************************ thinking of each process as a state time 0(n)space 0(1) ***********************/
        //help->https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
    public int maxProfitStates(int[] prices) {
        /*
        Think of s0 -> cool down s1->buying  s2->selling
        so when you buy you can look at the value at cool down
        when you sell you can look at the value you brought it at and add selling price
        and when you cool down just store the previous value of the cool down
        this form a triangle which can be easily seen in the image in help
       NOte: We look back one value for everything as that is the decision point

        * */
        if(prices.length<=1) return 0;
        int s0=0;
        int s1=-prices[0];
        int s2=0;
        for(int i=0;i<prices.length;i++){
            int last_s2=s2;
            s2=s1+prices[i];
            s1=Math.max(s1,s0-prices[i]);
            s0=Math.max(s0,last_s2);
        }
        return Math.max(s0,s2);
    }

    /************************ Normal dp way thinking of conditions time 0(n)space 0(1) ***********************/
    //help->https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n=prices.length;
        int b0=-prices[0];
        int s0=0,s1=0,s2=0,b1=b0;
        /*
        DONE FOR S2 TO STORE THE PRVIOUS TO PREVIOUS INDEX
        1 2 3 4 5
    s1=0 s2=0 s3=0 s3=s2
    s0=1  s0=2  s0=3 s0=4 s0=5
    s2=0  s2=1  s2=2  s2=3 s2=4
    s3=0  s3=0  s3=1  s3=2
    s1=1  s1=2  s1=3  s1=4
         */

        for(int i=1;i<n;i++){
            b0=Math.max(b1,s2-prices[i]);//do not buy anything or sell one back(sell i-2) before cooldown so you can buy now
            s0=Math.max(s1,b1+prices[i]);//do not sell anything or sell at index
            s2=s1;//
            s1=s0;
            b1=b0;
        }

        return s0;
    }



    }


