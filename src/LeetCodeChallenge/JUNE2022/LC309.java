package LeetCodeChallenge.JUNE2022;

public class LC309 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        //Once you have the state respresentation in your head this problem is peanuts
        int n = prices.length;
        int s0 = 0,s1 = -prices[0],s2 = 0;
        for(int i=1;i<n;i++){
            //Storing s2 as it's value will be modified
            int prevS2 = s2;
            //Selling here from s1 state of buying
            s2 = prices[i]+s1;
            //Is it better to buy now or take rest
            s1 = Math.max(s1,s0-prices[i]);
            //is it better to rest it out take the prev sold value
            s0 = Math.max(s0,prevS2);
        }
        //Either you sell or you rest buying at the end moment is useless
        return Math.max(s0,s2);
    }
}
