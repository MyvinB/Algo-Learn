package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 11:23 AM 1/20/2022
 */
public class LC875 {

    public static void main(String[] args) {
        int[] piles = new int[]{30,11,23,4,20};
        System.out.println(minEatingSpeed(piles,6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=1000000000;
        while(l<r){
            int m = (r+l)/2;
            int hr=0;
            for(int i=0;i<piles.length;i++){
                hr+=Math.ceil((double)piles[i]/m);
            }
            if(hr>h){
                l=m+1;
            }
            else r=m;
        }
        return l;
    }
}
