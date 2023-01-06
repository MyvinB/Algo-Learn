package Year2023.Jan;

import java.util.Arrays;

public class LC1833 {

    public static void main(String[] args) {
        int[] t = new int[]{1,6,3,1,2,5};
        System.out.println(maxIceCream(t,20));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int count = 0;
        for(int i=0;i<n;i++){
            if(coins-costs[i]>=0){
                count++;
                coins=coins-costs[i];
            }
        }
        return count;
    }
}
