class LC309{
    public int maxProfit(int[] prices) {
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
}
