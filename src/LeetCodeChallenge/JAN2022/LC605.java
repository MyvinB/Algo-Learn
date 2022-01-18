package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 11:22 AM 1/18/2022
 */
public class LC605 {

    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        int next = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(i>0){
                prev = flowerbed[i-1];
            }
            if(i<flowerbed.length-1){
                next = flowerbed[i+1];
            }
            if(flowerbed[i]==0 && prev == 0 && next==0){
                n--;
                flowerbed[i] = 1;
            }
        }
        return n<=0?true:false;
    }
}
