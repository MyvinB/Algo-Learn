package practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 9:07 AM 11/30/2021
 */
public class LC1710 {
    public static void main(String[] args) {
        int[][] boxes = new int[][]{{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxes,4));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int boxes = 0;
        for(int[] b:boxTypes){
            if(truckSize>=b[0]){
                boxes += b[0] * b[1];
                truckSize -= b[0];
            }
            else {
                boxes += truckSize * b[1];
                return boxes;
            }
        }
        return boxes;
    }
}
