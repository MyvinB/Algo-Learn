package LeetCode.Math;/*
 @author Myvin Barboza
 01/07/20 2:35 PM 
 */

public class LC441ArrangingCoins {

//formula  used n(n+1)/2
    //stupid way tle for 1804289383
    public int arrangeCoinsStupid(int n) {
        //sum of n number is n(n+1)/2
        long nLong=n;
        for(int i=0;i<=n;i++){
            long sum=(i*(i+1))/2;
            if(sum==nLong) return i;
            if(sum>nLong) return i-1;
        }

        return 0;
    }

    //logn
    public int arrangeCoins(int n) {
        long nLong=n;
    long low=0;
    long high=n;
    while(low<=high){
        long mid=low+(high-low)/2;
        //formula if greater then we
        if(mid *(mid+1)<=2*nLong){
            low=mid+1;
        }
        else high=mid-1;
    }
    //closest to the value required -1 as the before row is complete
    return (int) low-1;
    }

    //formula based to get the value x
    public int arrangeCoinsFormula(int n) {

        /*
        n = (x + 1) * x / 2
    x² + x = 2n
    x² + x + 1/4 - 1/4 = 2n
    (x + 1/2)² = 2n + 1 / 4
    (x + 1/2)² = (8n + 1) / 4
    x + 1/2 = sqrt(8n + 1) / 2
    x = (sqrt(8n + 1) / 2) - (1 / 2)
    x = (sqrt(8n + 1) - 1) / 2
         */
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
